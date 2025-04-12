package demo.mapper.ecology;

import demo.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HrMapper {


    /**
     * //获取请假实体 请假单一对一
     * @param requestID 流程id
     * @return 请假实体
     */
    @Select("select a.qjrxm,a.gh,a.qjsjq,a.qjsjz,a.qjlx,a.remark,a.requestid,a.lcbh from formtable_main_368 a where a.requestid = #{requestID}")
    @Results({
            @Result(property = "name", column = "qjrxm"),
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "startTime", column = "qjsjq"),
            @Result(property = "endTime", column = "qjsjz"),
            @Result(property = "type", column = "qjlx"),
            @Result(property = "reason", column = "remark"),
            @Result(property = "workflowID", column = "requestid"),
            @Result(property = "workflowNo", column = "lcbh")
    })
    Leave getLeaveInfo(@Param("requestID") int requestID);

    /**
     * 获得加班名单 加班单一对多
     * @param requestID 流程请求id
     * @return 返回加班实体集
     */
    @Select("select b.id,b.xm,b.gh,b.jbmc1,b.jbkssj,b.jbjzsj,b.jbyysy,b.jbsqlx,b.bcmc1,b.jbssh,a.lcbh,b.flag from formtable_main_466 a,formtable_main_466_dt1 b where a.requestid = #{requestID} and a.id = b.mainid and b.flag is null")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "xm"),
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "type", column = "jbmc1"),
            @Result(property = "startTime", column = "jbkssj"),
            @Result(property = "endTime", column = "jbjzsj"),
            @Result(property = "reason", column = "jbyysy"),
            @Result(property = "isChange", column = "jbsqlx"),
            @Result(property = "turn", column = "bcmc1"),
            @Result(property = "length", column = "jbssh"),
            @Result(property = "workflowNo", column = "lcbh"),
            @Result(property = "flag", column = "flag")
    })
    List<OverWorker> getOverWorkers(@Param("requestID") int requestID);

    @Update("update formtable_main_466_dt1 set flag = 'success' where id = #{id}")
    int updateOverWorkerFlag(@Param("id") int id);

    /**
     * 补卡集合 补卡单一对多
     * @param requestID 请求id
     * @return 补卡实体集合
     */
    @Select("select b.id,b.bdrxm,b.gh,b.bdyy,b.bdsj,a.lcbh,b.flag from formtable_main_366 a,formtable_main_366_dt1 b where a.requestid = #{requestID} and a.id = b.mainid and b.flag is null")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "bdrxm"),
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "reason", column = "bdyy"),
            @Result(property = "time", column = "bdsj"),
            @Result(property = "workflowNo", column = "lcbh"),
            @Result(property = "flag", column = "flag")
    })
    List<SupplyTime> getSupplyTimes(@Param("requestID") int requestID);

    @Update("update formtable_main_366_dt1 set flag = 'success' where id = #{id}")
    int updateSupplyTimeFlag(@Param("id") int id);

    @Select("select b.id,b.gh,b.xm,a.sqsj,b.jlbzyfbsjc,b.jclx,a.gsny,b.sqyj,a.lcbh,b.flag from formtable_main_469 a,formtable_main_469_dt1 b where a.requestid = #{requestID} and a.id = b.mainid and b.flag is null and b.flag is null")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "xm"),
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "requestTime", column = "sqsj"),
            @Result(property = "money", column = "jlbzyfbsjc"),
            @Result(property = "reason", column = "sqyj"),
            @Result(property = "type", column = "jclx"),
            @Result(property = "punishTime", column = "gsny"),
            @Result(property = "remark", column = "bdsj"),
            @Result(property = "workflowNo" ,column = "lcbh"),
            @Result(property = "flag", column = "flag")
    })
    List<RewardPunish> getRewardPunish(@Param("requestID") int requestID);
    
    @Update("update formtable_main_469_dt1 set flag = 'success' where id = #{id}")
    int updateRewardPunishFlag(@Param("id") int id);


    @Select("select a.ccrgh,a.ccrxm,a.kssj,a.jssj,a.ccscxs,a.sy,a.lcbh,a.cclx from formtable_main_459 a where a.requestid = #{requestID}")
    @Results({
            @Result(property = "username", column = "ccrxm"),
            @Result(property = "employeeID", column = "ccrgh"),
            @Result(property = "startTime", column = "kssj"),
            @Result(property = "endTime", column = "jssj"),
            @Result(property = "type", column = "cclx"),
            @Result(property = "hours", column = "ccscxs"),
            @Result(property = "reason", column = "sy"),
            @Result(property = "workflowNo", column = "lcbh")
    })
    BusinessLeave getBusinessLeave(@Param("requestID") int requestID);

    @Select("select a.xjrxm,a.gh,a.xjsjq,a.xjsjz,a.xjlx,a.xjyy,a.xjsct,a.yqjlcbh,a.lcbh from  formtable_main_369 a where a.requestid = #{requestID}")
    @Results({
            @Result(property = "name", column = "xjrxm"),
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "startTime", column = "xjsjq"),
            @Result(property = "endTime", column = "xjsjz"),
            @Result(property = "type", column = "xjlx"),
            @Result(property = "length", column = "xjsct"),
            @Result(property = "reason", column = "xjyy"),
            @Result(property = "workflowID", column = "yqjlcbh"),
            @Result(property = "workflowNo", column = "lcbh")
    })
    ResetLeave getResetLeave(@Param("requestID") int requestID);
}
