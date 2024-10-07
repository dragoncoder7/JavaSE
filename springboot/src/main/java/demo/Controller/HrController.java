package demo.Controller;

import demo.Service.HrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/HrController")
public class HrController {
    public static final Logger LOGGER = LoggerFactory.getLogger(HrController.class);

    private final HrService hrService;

    public HrController(HrService hrService){
        this.hrService = hrService;
    }

    @RequestMapping(value = "/syncOvertime",method = RequestMethod.POST)
    public Map<String,Object> syncOvertime(Map<String,Object> map){
        return hrService.syncOvertime((Integer) map.get("requestId"));
    }

    /**
     * 科伦特请假数据同步HR
     * @param map 传递requestId
     * @return map结果集 返回到节点附加操作对结果集进行处理
     */
    @RequestMapping(value = "/syncLeave",method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public Map<String,Object> syncLeave(@RequestBody Map<String,Object> map){
        LOGGER.info(map.toString());
        int requestId = Integer.parseInt(map.get("requestId").toString());
        int workflowId = Integer.parseInt(map.get("workflowId").toString());
        /*
         * map要给的数据 workflowid requestid
         */
        return hrService.syncLeave(requestId,workflowId);
    }

    @RequestMapping(value = "/sync",method = RequestMethod.POST)
    public static Map<String,Object> syncHrInform(Map<String,Object> map){
        String type = map.get("type").toString();
        String action;
        //好像不用 直接在流程那边 把对应的action带过来就可以了
        switch (type) {
            case "加班" -> action = "setOvertime";
            case "请假" -> action = "setLeave";
            case "销假" -> action = "ResetLeave";
            case "出差" -> action = "setBusinessLeave";
            case "奖惩" -> action = "setRewardPunishment";
            case "签卡" -> action = "settimerecords";
            default -> {
            }
        }
        map.put("type","saasdf");
        LOGGER.info(map.toString());
        return new HashMap<>();
    }

    public static void main(String[] args) {
        callApi();
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(){
        Map<String,Object> map = new HashMap<>();
        map.put("requestId",9002350);
        Map<String,Object> res = syncLeave(map);
        return res.toString();
    }
    public static void  callApi(){

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/HrController/syncLeave";

        Map<String, Object> requestMap = new HashMap<>();

        requestMap.put("requestId", "9002350");

        Map<String,Object> response = restTemplate.postForObject(url, requestMap, Map.class);

        LOGGER.info(response.toString());
    }

}
