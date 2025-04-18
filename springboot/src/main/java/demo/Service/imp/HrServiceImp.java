package demo.Service.imp;

import demo.Service.HrService;
import demo.Utils.Hr;
import demo.entity.*;
import demo.mapper.ecology.CommonMapper;
import demo.mapper.ecology.HrMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service

public class HrServiceImp implements HrService {

    public static final Logger LOGGER = LoggerFactory.getLogger(HrServiceImp.class);


    private final Hr hr;

    private final HrMapper hrMapper;

    private final CommonMapper commonMapper;

    public HrServiceImp(Hr hr, HrMapper hrMapper, CommonMapper commonMapper){
        this.hr = hr;
        this.hrMapper = hrMapper;
        this.commonMapper = commonMapper;
    }
    //同步加班
    @Override
    public Map<String, Object> syncOvertime(int requestId, int workflowID) {


        Map<String, Object> map = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();

        int failedCount = 0;

        int count = 0;

        try {
            List<OverWorker> overWorkerList = hrMapper.getOverWorkers(requestId);

            JsonNode jsonNode = objectMapper.readTree(init());

            for (OverWorker overWorker : overWorkerList) {
                //构造数据
                //overWorker.setLength(timeDiff(overWorker.getStartTime().replaceAll("\\s+", " "), overWorker.getEndTime().replaceAll("\\s+", " ")));
                overWorker.setTime(overWorker.getStartTime().split(" ")[0]);

                ((ObjectNode) jsonNode).put("username", overWorker.getName());
                ((ObjectNode) jsonNode).put("a0190", overWorker.getEmployeeID());
                ((ObjectNode) jsonNode).put("k1905", commonMapper.getMappingValue(workflowID, "jbmc1", String.valueOf(overWorker.getType())).trim());
                ((ObjectNode) jsonNode).put("k1906", overWorker.getTime());
                ((ObjectNode) jsonNode).put("k1907", overWorker.getStartTime().replaceAll("\\s+", " "));
                ((ObjectNode) jsonNode).put("k1909", overWorker.getEndTime().replaceAll("\\s+", " "));
                ((ObjectNode) jsonNode).put("k1913", overWorker.getLength());
                ((ObjectNode) jsonNode).put("k1915", overWorker.getReason());
                ((ObjectNode) jsonNode).put("k191C", commonMapper.getMappingValue(workflowID, "bcmc1", String.valueOf(overWorker.getTurn())).trim());
                ((ObjectNode) jsonNode).put("k1920", overWorker.getIsChange() == 0 ? "是" : "否");
                ((ObjectNode) jsonNode).put("OAFlowID", overWorker.getWorkflowNo());
                ((ObjectNode) jsonNode).put("action", "setOvertime");

                //处理数据结果
                count++;
                String res = hr.Post(jsonNode.toString());
                JsonNode responseNode = objectMapper.readTree(res).get(0);
                if (responseNode.get("error") != null){
                    failedCount++;
                    map.put(String.valueOf(count),responseNode.get("error").asText());
                } else if (!responseNode.get("msg").asText().equals("OK!")){
                    failedCount++;
                    map.put(String.valueOf(count),responseNode.get("msg").asText());
                } else {
                    try {
                        int i = hrMapper.updateOverWorkerFlag(overWorker.getId());
                        if (i == 1){
                            LOGGER.info("更新数据标识成功"+overWorker.getEmployeeID());
                        }
                    } catch (Exception e){
                        LOGGER.info("更新数据标识异常！"+e.getMessage());
                    }
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            LOGGER.info("发生异常："+e);
            map.put("status","failure");
            map.put("msg",e);
        }
        if (failedCount > 0) {
            map.put("status","failure");
        }else {
            map.put("status","success");
        }
        return map;
    }
    //同步请假
    @Override
    public Map<String, Object> syncLeave(int requestID,int workflowId) {

        Map<String, Object> map;
        try {
            Leave leave = hrMapper.getLeaveInfo(requestID);

            LOGGER.info(commonMapper.getMappingValue(workflowId, "qjlx", leave.getType()).trim());

            String body = init();

            //leave.setLength();

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper.readTree(body);

//            ((ObjectNode) jsonNode).put("username", leave.getName());
            ((ObjectNode) jsonNode).put("a0190", leave.getEmployeeID());
            ((ObjectNode) jsonNode).put("username", "system");
//            ((ObjectNode) jsonNode).put("a0190", "1206004");
            ((ObjectNode) jsonNode).put("beg", leave.getStartTime());
            ((ObjectNode) jsonNode).put("end", leave.getEndTime());
            ((ObjectNode) jsonNode).put("K2012", leave.getReason());
            ((ObjectNode) jsonNode).put("k2005", commonMapper.getMappingValue(workflowId, "qjlx", leave.getType()).trim());
            ((ObjectNode) jsonNode).put("OA_ID", leave.getWorkflowID());
            ((ObjectNode) jsonNode).put("OAFlowID", leave.getWorkflowNo());


            map = calculate(jsonNode, commonMapper.getWorkflowStatus(requestID));

            LOGGER.info(jsonNode.asText());

            if (map.get("status").equals("success")) {

                ((ObjectNode) jsonNode).put("k2010", Float.parseFloat(map.get("time").toString()) / 8);
                ((ObjectNode) jsonNode).put("k2011", Float.parseFloat(map.get("time").toString()));
                ((ObjectNode) jsonNode).put("action", "setLeave");

                hr.Post(jsonNode.toString());

            } else {
                return map;
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
    //同步销假
    @Override
    public Map<String, Object> syncResetLeave(int requestID, int workflowId) {
        Map<String, Object> map = new HashMap<>();
        try {
            ResetLeave resetLeave = hrMapper.getResetLeave(requestID);

            resetLeave.setType(commonMapper.getMappingValue(workflowId,"xjlx", resetLeave.getType()).trim());

            resetLeave.setReason(commonMapper.getMappingValue(workflowId,"xjyy", resetLeave.getReason()).trim());


            String body = init();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(body);

            ((ObjectNode) jsonNode).put("username", "system");
            //((ObjectNode) jsonNode).put("a0190", "1206004");
            ((ObjectNode) jsonNode).put("a0190", resetLeave.getEmployeeID());
            ((ObjectNode) jsonNode).put("k2005", resetLeave.getType());
            ((ObjectNode) jsonNode).put("beg", resetLeave.getStartTime());
            ((ObjectNode) jsonNode).put("end", resetLeave.getEndTime());
            ((ObjectNode) jsonNode).put("OAFlowID", resetLeave.getWorkflowNo());
            ((ObjectNode) jsonNode).put("OA_ID", resetLeave.getWorkflowID());
            ((ObjectNode) jsonNode).put("K2012", resetLeave.getReason());

            map = calculate(jsonNode , commonMapper.getWorkflowStatus(requestID));

            LOGGER.info(jsonNode.asText());

            if (map.get("status").equals("success")) {

                ((ObjectNode) jsonNode).put("k2010", Float.parseFloat(map.get("time").toString()) / 8);
                ((ObjectNode) jsonNode).put("k2011", Float.parseFloat(map.get("time").toString()));
                ((ObjectNode) jsonNode).put("action", "ResetLeave");

                hr.Post(jsonNode.toString());

            } else {
                return map;
            }
        } catch (Exception e) {
            LOGGER.info("发生异常："+e);
            map.put("status","failure");
            map.put("msg",e);
        }
        return map;
    }
    //同步出差
    @Override
    public Map<String, Object> syncBusinessLeave(int requestID) {
        Map<String, Object> map = new HashMap<>();
        try {

            BusinessLeave businessLeave = hrMapper.getBusinessLeave(requestID);
            ObjectMapper objectMapper = new ObjectMapper();

            String body = init();
            JsonNode jsonNode = objectMapper.readTree(body);

            ((ObjectNode) jsonNode).put("action", "setBusinessLeave");
            ((ObjectNode) jsonNode).put("username", "system");
            //((ObjectNode) jsonNode).put("a0190", "1206004");
            ((ObjectNode) jsonNode).put("a0190", businessLeave.getEmployeeID());
            ((ObjectNode) jsonNode).put("k2005", businessLeave.getType() == 0 ? "公出" : "出差");
            ((ObjectNode) jsonNode).put("beg", businessLeave.getStartTime());
            ((ObjectNode) jsonNode).put("end", businessLeave.getEndTime());
            ((ObjectNode) jsonNode).put("k2011", businessLeave.getHours());
            ((ObjectNode) jsonNode).put("k2010", businessLeave.getHours() / 8);
            //((ObjectNode) jsonNode).put("C029007", rewardpunish.getWorkflowID());
            ((ObjectNode) jsonNode).put("OA_ID", requestID);
            ((ObjectNode) jsonNode).put("OAFlowID", businessLeave.getWorkflowNo());
            ((ObjectNode) jsonNode).put("K2012", businessLeave.getReason());

            commonRes(map,objectMapper,jsonNode);

            if (map.get("status").equals("failure")){
                return map;
            }
        } catch (Exception e) {
            LOGGER.info("发生异常："+e);
            map.put("status","failure");
            map.put("msg",e);
        }
        return map;
    }
    //同步奖惩
    @Override
    public Map<String, Object> syncRewardPunishment(int requestID) {
        int failedCount = 0;

        int count = 0;
        Map<String, Object> map = new HashMap<>();
        List<RewardPunish> list = hrMapper.getRewardPunish(requestID);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (RewardPunish rewardpunish : list) {
                count++;
                String body = init();
                int value = rewardpunish.getType();
                String type = "";
                if (value >= 0 && value <= 3){
                    type = "奖励";
                }else if (value >= 4 && value <= 7){
                    type = "惩罚";
                }

                JsonNode jsonNode = objectMapper.readTree(body);
                ((ObjectNode) jsonNode).put("action", "setRewardPunishment");
                ((ObjectNode) jsonNode).put("username", "system");
                //((ObjectNode) jsonNode).put("a0190", "1206004");
                ((ObjectNode) jsonNode).put("a0190", rewardpunish.getEmployeeID());
                ((ObjectNode) jsonNode).put("C029008", rewardpunish.getRequestTime());
                ((ObjectNode) jsonNode).put("C029009", rewardpunish.getMoney());
                ((ObjectNode) jsonNode).put("C029013", type);
                ((ObjectNode) jsonNode).put("C029015", rewardpunish.getPunishTime().replace("-",""));
                ((ObjectNode) jsonNode).put("C02901", rewardpunish.getReason());
                ((ObjectNode) jsonNode).put("OAFlowID", rewardpunish.getWorkflowNo());
                ((ObjectNode) jsonNode).put("OA_ID", requestID);

                //处理数据结果
                String res = hr.Post(jsonNode.toString());
                JsonNode responseNode = objectMapper.readTree(res).get(0);
                if (responseNode.get("error") != null){
                    failedCount++;
                    map.put(String.valueOf(count),responseNode.get("error").asText());
                } else if (!responseNode.get("msg").asText().equals("OK!")){
                    failedCount++;
                    map.put(String.valueOf(count),responseNode.get("msg").asText());
                } else {
                    try {
                        int i = hrMapper.updateOverWorkerFlag(rewardpunish.getId());
                        if (i == 1){
                            LOGGER.info("更新数据标识成功"+rewardpunish.getEmployeeID());
                        }
                    } catch (Exception e){
                        LOGGER.info("更新数据标识异常！"+e.getMessage());
                    }
                }
            }
        }catch (Exception e){
            LOGGER.info("发生异常："+e);
            map.put("status","failure");
            map.put("msg",e);
        }
        if (failedCount > 0) {
            map.put("status","failure");
        }else {
            map.put("status","success");
        }
        return map;
    }
    //同步考勤
    @Override
    public Map<String, Object> syncTimeRecords(int requestID,int workflowId) {
        int failedCount = 0;

        int count = 0;
        Map<String, Object> map = new HashMap<>();
        List<SupplyTime> list = hrMapper.getSupplyTimes(requestID);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            for (SupplyTime entity : list) {
                JsonNode jsonNode = objectMapper.readTree(init());
                ((ObjectNode) jsonNode).put("username", "system");
                ((ObjectNode) jsonNode).put("a0190", entity.getEmployeeID());
                ((ObjectNode) jsonNode).put("TMRecores", entity.getTime());
                ((ObjectNode) jsonNode).put("OAFlowID", entity.getWorkflowNo());
                ((ObjectNode) jsonNode).put("OA_ID", requestID);
                ((ObjectNode) jsonNode).put("reason", commonMapper.getMappingValue(workflowId,"bdyy",entity.getReason()).trim());
                ((ObjectNode) jsonNode).put("action", "settimerecords");

                //处理数据结果
                count++;
                String res = hr.Post(jsonNode.toString());
                JsonNode responseNode = objectMapper.readTree(res).get(0);
                if (responseNode.get("error") != null){
                    failedCount++;
                    map.put(String.valueOf(count),responseNode.get("error").asText());
                } else if (!responseNode.get("msg").asText().equals("OK!")){
                    failedCount++;
                    map.put(String.valueOf(count),responseNode.get("msg").asText());
                } else {
                    try {
                        int i = hrMapper.updateOverWorkerFlag(entity.getId());
                        if (i == 1){
                            LOGGER.info("更新数据标识成功"+entity.getEmployeeID());
                        } else {
                            LOGGER.info("更新数据标识失败"+entity.getEmployeeID());
                        }
                    } catch (Exception e){
                        LOGGER.info("更新数据标识异常！"+e.getMessage());
                    }
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            LOGGER.info("产生异常："+e);
            map.put("status","failure");
            map.put("msg",e);
        }
        if (failedCount > 0) {
            map.put("status","failure");
        }else {
            map.put("status","success");
        }
        return map;
    }



    /**
     * 计算请假时长 以及判断是否重复请假
     * @param jsonNode 请假信息
     * @param  currentNode 当前流程所在的节点 0 创建节点 // 1 审批中 // 2 提醒 // 3 已归档
     * @return  map结果集
     */
    private Map<String,Object> calculate(JsonNode jsonNode,int currentNode){
        Map<String,Object> map = new HashMap<>();
        ((ObjectNode) jsonNode).put("action", "getcalculator");
        LOGGER.info(jsonNode.toString());

        //接口调用
        String res = hr.Post(jsonNode.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            JsonNode resNode = objectMapper.readTree(res).get(0);
            String error = resNode.get("leaveJCXX").asText();
            if (!error.isEmpty()){
                map.put("msg",error);
                map.put("status","failure");
                map.put("time","-1");
            }else {
                map.put("msg","");
                map.put("status","success");
                map.put("time",resNode.get("hh").asText());
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
    //适用于处理单条数据的hr流程
    private void commonRes(Map<String, Object> map, ObjectMapper objectMapper, JsonNode jsonNode) throws JsonProcessingException {
        String res = hr.Post(jsonNode.toString());

        JsonNode responseNode = objectMapper.readTree(res).get(0);

        if (responseNode.get("error") != null){
            map.put("msg",responseNode.get("error").asText());
            map.put("status","failure");
        } else if (!responseNode.get("msg").asText().equals("OK!")){
            map.put("msg",responseNode.get("msg").asText());
            map.put("status","failure");
        }else {
            map.put("msg",responseNode.get("msg"));
            map.put("status","success");
        }
    }

    private String init(){
        return "{\n" +
                "                }";
    }

    public boolean checkInfo(String username, String employeeId){
        ObjectMapper objectMapper = new ObjectMapper();
        String body = "{\n" +
                "                    \"action\": \"CheckA0190\",\n" +
                "                    \"username\": \"system\",\n" +
                "                    \"a0190\": \"\",\n" +
                "                    \"a0101\": \"\"\n" +
                "                }";


        try {
            JsonNode request = objectMapper.readTree(body);
            ((ObjectNode) request).put("a0190", employeeId);
            ((ObjectNode) request).put("a0101", username);
            String response = hr.Post(request.toString());
            JsonNode jsonNode = objectMapper.readTree(response).get(0);
            String msg = jsonNode.get("msg").asText();
            return Objects.equals(msg, "success");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
