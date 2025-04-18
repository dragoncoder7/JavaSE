package demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.Service.LeaveService;
import demo.Service.TravelService;
import demo.entity.LeaveInfo;
import demo.entity.Message;
import demo.entity.TravelInfo;
import demo.mapper.ecology.TravelMapper;
import demo.mapper.hr.LeaveMapper;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ToHeliosController {
    public static final Logger LOGGER = LoggerFactory.getLogger(ToHeliosController.class);

    private final TravelService travelService ;
    private final LeaveService leaveService ;


    @Resource
    TravelMapper travelMapper;

    @Resource
    LeaveMapper leaveMapper;

    //@Autowired
    public ToHeliosController(TravelService travelService, LeaveService leaveService) {
        // 默认构造器
        this.travelService = travelService;
        this.leaveService = leaveService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    @Transactional
    public String test(@RequestParam(defaultValue = "0") int requestID){
        TravelInfo travelInfo = travelService.getTravelInfo(requestID);
        LOGGER.info(travelInfo.toString());
        return travelInfo.toString();
        //LOGGER.info(travelInfo.toString());




//        List<LeaveInfo> leaveInfos = travelMapper.getLeaveInfo(9002116);//
//
//        int successCount = 0;
//        try {
//            for (LeaveInfo people : leaveInfos) {
//
//                people.setId(leaveMapper.getHrID(people.getEmployeeID()));
//
//                int res = leaveService.push(people);
//
//                LOGGER.info("汇联易出差单 出差人"+people.getName()+"出差推送HR结果:"+(res == 1 ? "success" : "failure"));
//
//                if (res == 1){
//                    successCount++;
//                }
//            }
//        }catch (Exception e){
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            LOGGER.info("产生异常，回滚本次所有的推HR的操作！"+e);
//        }
//
//
//        if (successCount != leaveInfos.size()){
//            LOGGER.info("successCount:"+successCount +" all:"+leaveInfos.size());
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            LOGGER.info("有数据推送失败，回滚本次所有的推HR的操作");
//            return "failure";
//        }
//        return "success";


//        int requestId = 9002149;
//
//        //调用汇联易人员接口 补全汇联易公司、部门、人员oid、状态、账号是否已激活等信息
//        LOGGER.info(String.valueOf(travelInfo));
//
//        List<String> participantslist = travelMapper.getParticipants(requestId);//获取参与人的姓名
//        travelInfo.setParticipant(String.join(",",participantslist));
//
//        List<String> workAgentlist = travelMapper.getWorkAgents(requestId);//获取汇联易的工作代理人
//
//        Iterator<String> iterator = workAgentlist.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            if (!travelService.isHasHeliosAccount(travelService.getHeliosPeopleInfo(s))) {
//                iterator.remove();  // 使用 Iterator 的 remove 方法来删除元素
//            }
//        }
//        travelInfo.setWorkAgent(String.join(",",workAgentlist));
//        for (String s: workAgentlist
//        ) {
//            if (!travelService.isHasHeliosAccount(travelService.getHeliosPeopleInfo(s))){
//                workAgentlist.remove(s);
//            }
//        }


//        String token = tokenService.getToken();
//        if (token == null || token.equals("failure")){
//            return "failure";
//        }else
//            return tokenService.toString();
//        return String.valueOf(travelInfo);
    }
    @RequestMapping(value = "/travelApplication/create", method = RequestMethod.POST, consumes = "application/json",produces = "application/json; charset=UTF-8")
    public synchronized Message createTravelApply(@RequestBody String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        int requestId;
        try {
            JsonNode request = objectMapper.readTree(body);
            requestId = request.get("requestId").asInt();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String businessCode = travelMapper.isWrittenToHelios(requestId);
        if (businessCode != null && !businessCode.isEmpty()){
            LOGGER.info("该OA单已成功创建过汇联易单据！"+businessCode);
            return new Message("200","Succeed","该OA单已成功创建过汇联易单据！"+businessCode);
        }

        Message res = travelService.createTravelApply(requestId);

        LOGGER.info("controller输出："+res);

        return res;

    }
    @RequestMapping(value = "/pushHr", method = RequestMethod.POST, consumes = "application/json",produces = "application/json; charset=UTF-8")
    @Transactional
    public synchronized Message pushHrInfo(@RequestBody String body){
        LOGGER.info("请求信息："+body);
        String message = null;
        ObjectMapper objectMapper = new ObjectMapper();
        int requestId ;
        try {
            JsonNode request = objectMapper.readTree(body);
            requestId = request.get("requestId").asInt();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String isWrittenToHr = travelMapper.isWrittenToHr(requestId);

        if (isWrittenToHr != null && isWrittenToHr.equals("success")){
            return new Message("200","Succeed", "已成功推送过HR数据，无需重复处理");
        }

        List<LeaveInfo> leaveInfos = travelMapper.getLeaveInfo(requestId);

        int successCount = 0;

        try {
            for (LeaveInfo people : leaveInfos) {

                people.setId(leaveMapper.getHrID(people.getEmployeeID()));

                int res = leaveService.push(people);

                String errorMessage ;

                switch (res) {
                    case  1 : {
                        errorMessage = "success";
                        break;
                    }
                    case  0 : {
                        errorMessage = "failure! 参考OA首页HR相关文档";
                        break;
                    }
                    case  -1: {
                        errorMessage = "failure! 导入的数据包含已存档的月份，不允许导入。";
                        break;
                    }
                    default: {
                        errorMessage = "其他失败原因！联系IT查看日志。";
                    }
                }

                message = "汇联易出差单 出差人"+people.getName()+"出差推送HR结果:"+errorMessage;

                LOGGER.info(message);

                if (res == 1){
                    successCount++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.info("产生异常，回滚本次所有的推HR的操作！"+e);
            return new Message("-1","failure","异常bug，回滚本次所有的推HR的操作！"+e);
        }


        if (successCount != leaveInfos.size()){
            LOGGER.info("successCount:"+successCount +" all:"+leaveInfos.size());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            LOGGER.info("有数据推送失败，回滚本次所有的推HR的操作");
            return new Message("-1","failure","HR推送失败，全部回滚，具体失败原因："+message);
        }

        String result = travelMapper.updateHrStatus(requestId) == 1 ? "success" : "failure";

        LOGGER.info("更新HR推送结果:"+requestId+" "+result);

        return new Message("200","success", String.valueOf(successCount));
    }
}