package demo.Service.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.Service.HrService;
import demo.Utils.Hr;
import demo.entity.Leave;
import demo.mapper.ecology.CommonMapper;
import demo.mapper.ecology.HrMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    @Override
    public Map<String, Object> syncOvertime(int requestId) {

        return null;
    }

    @Override
    public Map<String, Object> syncLeave(int requestID,int workflowId) {

        Leave leave = hrMapper.getLeaveInfo(requestID);

        LOGGER.info(commonMapper.getMappingValue(workflowId,"qjlx",leave.getType()).trim());

        String body = initLeave();

        //leave.setLength();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map;
        try {
            JsonNode jsonNode = objectMapper.readTree(body);

//            ((ObjectNode) jsonNode).put("username", leave.getName());
//            ((ObjectNode) jsonNode).put("a0190", leave.getEmployeeID());
            ((ObjectNode) jsonNode).put("username", "system");
            ((ObjectNode) jsonNode).put("a0190", "1206004");
            ((ObjectNode) jsonNode).put("beg", leave.getStartTime());
            ((ObjectNode) jsonNode).put("end", leave.getEndTime());
            ((ObjectNode) jsonNode).put("K2012", leave.getReason());
            ((ObjectNode) jsonNode).put("k2005", commonMapper.getMappingValue(workflowId,"qjlx",leave.getType()).trim());
            ((ObjectNode) jsonNode).put("OA_ID", leave.getWorkflowID());

            map = calculate(jsonNode);

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

    @Override
    public Map<String, Object> syncResetLeave() {
        return null;
    }

    @Override
    public Map<String, Object> syncBusinessLeave() {
        return null;
    }

    @Override
    public Map<String, Object> syncRewardPunishment() {
        return null;
    }

    @Override
    public Map<String, Object> syncTimeRecords() {
        return null;
    }

    private String initLeave(){
        return """
                {
                }""";
    }

    /**
     * 计算请假时长 以及判断是否重复请假
     * @param jsonNode 请假信息
     * @return  map结果集
     */
    private Map<String,Object> calculate(JsonNode jsonNode){
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
                map.put("error",error);
                map.put("status","failure");
                map.put("time","-1");
            }else {
                map.put("error","");
                map.put("status","success");
                map.put("time",resNode.get("hh").asText());
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
