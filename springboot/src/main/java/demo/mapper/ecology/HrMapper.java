package demo.mapper.ecology;

import demo.entity.Leave;
import org.apache.ibatis.annotations.*;

@Mapper
public interface HrMapper {
    //获取请假信息
    @Select("select a.qjrxm,a.gh,a.qjsjq,a.qjsjz,a.qjlx,a.remark,a.requestid from formtable_main_368 a where a.requestid = #{requestID}")
    @Results({
            @Result(property = "name", column = "qjrxm"),
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "startTime", column = "qjsjq"),
            @Result(property = "endTime", column = "qjsjz"),
            @Result(property = "type", column = "qjlx"),
            @Result(property = "reason", column = "remark"),
            @Result(property = "workflowID", column = "requestid")
    })
    Leave getLeaveInfo(@Param("requestID") int requestID);

    @Select("select a.qjrxm from formtable_main_368 a where a.requestid = 9002350")
    String test();
}
