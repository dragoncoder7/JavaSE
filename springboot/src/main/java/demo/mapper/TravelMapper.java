package demo.mapper;

import demo.entity.TravelInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TravelMapper {
    @Select("SELECT gh , qsrq1 , jzrq1 , cclx , sy , ydjp , zwdlr , xxdd , ccry from formtable_main_17 where requestid = #{requestId}")
    @Results({
            @Result(property = "employeeID", column = "gh"),
            @Result(property = "start_date", column = "qsrq1"),
            @Result(property = "end_date", column = "jzrq1"),
            @Result(property = "travelType", column = "cclx"),
            @Result(property = "businessReason", column = "sy"),
            @Result(property = "isOrderAirTicket", column = "ydjp"),
            @Result(property = "WorkAgent", column = "zwdlr"),
            @Result(property = "city", column = "xxdd"),
            @Result(property = "participant", column = "ccry")
    })
    TravelInfo getTravelInfo(@Param("requestId") int requestId);
    @Select("select gh from formtable_main_17 where requestid = #{requestId}")
    String getGH(@Param("requestId") int requestId);
}
