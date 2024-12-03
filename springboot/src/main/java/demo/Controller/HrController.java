package demo.Controller;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import demo.Service.HrService;
import demo.entity.User;
import demo.mapper.mysql.AllMapper;
import demo.mapper.mysql.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/HrController")
public class HrController {
    public static final Logger LOGGER = LoggerFactory.getLogger(HrController.class);

    private final HrService hrService;

    private final UserMapper userMapper;

    private final AllMapper allMapper;


    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }


    public HrController(HrService hrService, UserMapper userMapper, AllMapper allMapper){
        this.hrService = hrService;
        this.userMapper = userMapper;
        //testSelect();
        this.allMapper = allMapper;
    }

    /**
     * 科伦特加班数据同步HR
     * @param map 请求体响应结果
     * @return 响应结果
     */
    @RequestMapping(value = "/syncOvertime", method = RequestMethod.POST, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    public Map<String,Object> syncOvertime(@RequestBody Map<String,Object> map){
        LOGGER.info(map.toString());

        int requestId = Integer.parseInt(map.get("requestId").toString());

        int workflowID = Integer.parseInt(map.get("workflowId").toString());

        return hrService.syncOvertime(requestId,workflowID);
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

        return hrService.syncLeave(requestId,workflowId);
    }

    /**
     * 科伦特出差数据同步HR
     * @param map 请求体
     * @return 响应结果
     */
    @RequestMapping(value = "/syncBusinessLeave",method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public Map<String,Object> syncBusinessLeave(@RequestBody Map<String,Object> map){
        LOGGER.info(map.toString());

        int requestId = Integer.parseInt(map.get("requestId").toString());

        return hrService.syncBusinessLeave(requestId);
    }

    /**
     * 科伦特销假数据同步HR
     * @param map 请求体
     * @return 响应结果
     */
    @RequestMapping(value = "/syncResetLeave",method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public Map<String,Object> syncResetLeave(@RequestBody Map<String,Object> map){
        LOGGER.info(map.toString());

        int requestId = Integer.parseInt(map.get("requestId").toString());

        int workflowId = Integer.parseInt(map.get("workflowId").toString());

        return hrService.syncResetLeave(requestId,workflowId);
    }

    /**
     * 科伦特考勤数据同步HR
     * @param map 请求体响应结果
     * @return 响应结果
     */
    @RequestMapping(value = "/syncTimeRecords", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public Map<String, Object> syncTimeRecords(@RequestBody Map<String, Object> map) {
        LOGGER.info(map.toString());

        int requestId = Integer.parseInt(map.get("requestId").toString());
        int workflowId = Integer.parseInt(map.get("workflowId").toString());
        return hrService.syncTimeRecords(requestId, workflowId);
    }

    /**
     * 科伦特奖惩数据同步HR
     * @param map 请求体响应结果
     * @return 响应结果
     */
    @RequestMapping(value = "/syncRewardPunishment", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public Map<String, Object> syncRewardPunishment(@RequestBody Map<String, Object> map) {
        LOGGER.info(map.toString());

        int requestId = Integer.parseInt(map.get("requestId").toString());

        return hrService.syncRewardPunishment(requestId);
    }



    public static void main(String[] args) {

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println(allMapper.getAllUsers());
        User user = userMapper.selectById(1);
        System.out.println(user);

        return "res.toString()";
    }

    @RequestMapping(value = "/checkInfo", method = RequestMethod.GET)
    public boolean checkInfo(@Param("username") String username, @Param("employeeId") String employeeId) {
        LOGGER.info("username :" + username);
        LOGGER.info("employeeId :" + employeeId);
        return hrService.checkInfo(username, employeeId);
    }

}
