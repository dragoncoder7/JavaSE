package demo.mapper.ecology;

import demo.entity.LeaveInfo;
import demo.entity.TravelInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TravelMapper {
    @Select("SELECT gh , qsrq1 , jzrq1 , cclx , sy , ydjp , zwdlr , cccs , ccry , xmh, xmhsm , fybm , yzlf ,qxzyscdwj from formtable_main_17 where requestid = #{requestId}")
    @Results({
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "start_date", column = "qsrq1"),
            @Result(property = "end_date", column = "jzrq1"),
            @Result(property = "travelType", column = "cclx"),
            @Result(property = "businessReason", column = "sy"),
            @Result(property = "isOrderAirTicket", column = "ydjp"),
            @Result(property = "WorkAgent", column = "zwdlr"),
            @Result(property = "city", column = "cccs",jdbcType = JdbcType.CLOB),
            @Result(property = "participant", column = "ccry"),
            @Result(property = "projectNo", column = "xmh"),
            @Result(property = "projectNoDesc", column = "xmhsm"),
            @Result(property = "departmentID", column = "fybm"),
            @Result(property = "TravelFee", column = "yzlf"),
            @Result(property = "attachmentID", column = "qxzyscdwj")
    })
    TravelInfo getTravelInfo(@Param("requestId") int requestId);
    @Select("select gh from formtable_main_17 where requestid = #{requestId}")
    String getGH(@Param("requestId") int requestId);

    @Select("select b.ccrxm from formtable_main_17 a , formtable_main_17_dt2 b where a.id = b.mainid and a.requestid = #{requestId}")
    List<String> getParticipants(@Param("requestId") int requestId);

    @Select("select b.zwdlrgh from formtable_main_17 a , formtable_main_17_dt2 b where a.id = b.mainid and a.requestid = #{requestId} order by b.id")
    List<String> getWorkAgents(@Param("requestId") int requestId);

    @Select("select b.gh, b.ccrxm, a.qsrq1, a.jzrq1, a.ts3,a.sy, a.lcbh from formtable_main_17 a , formtable_main_17_dt2 b where a.id = b.mainid and a.requestid = #{requestId} order by b.id")
    @Results({
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "name", column = "ccrxm"),
            @Result(property = "startTime", column = "qsrq1"),
            @Result(property = "endTime", column = "jzrq1"),
            @Result(property = "length", column = "ts3"),
            @Result(property = "reason", column = "sy"),
            @Result(property = "OaWorkflowNo", column = "lcbh")
    })
    List<LeaveInfo> getLeaveInfo(@Param("requestId") int requestId);

    @Select("select a.documentno from oa2hr2helios a where a.requestid = #{requestId}")
    String isWrittenToHelios(@Param("requestId") int requestId);

    @Select("select a.istohr from oa2hr2helios a where a.requestid = #{requestId}")
    String isWrittenToHr(@Param("requestId") int requestId);

    @Update("Update oa2hr2helios a set a.ISTOHR = 'success' where a.REQUESTID = #{requestId} ")
    int updateHrStatus(@Param("requestId") int requestId);

    @Update("Update oa2hr2helios a set a.DOCUMENTNO = #{businessCode} where a.REQUESTID = #{requestId} ")
    int updateHeliosStatus(@Param("businessCode") String businessCode,@Param("requestId") int requestId);
}
