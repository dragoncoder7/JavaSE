package demo.mapper;

import demo.entity.TravelInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface TravelMapper {
    @Select("SELECT gh AS employeeID, qsrq1 AS start_date, jzrq1 AS end_date, cclx AS travelType, sy AS businessReason, ydjp AS isOrderAirTicket, zwdlr AS WorkAgent, xxdd AS city, ccry AS participant from formtable_main_17 where requestid = #{requestId}")
    TravelInfo getTravelInfo(@Param("requestId") int requestId);
    @Select("select gh from formtable_main_17 where requestid = #{requestId}")
    String getGH(@Param("requestId") int requestId);
}
