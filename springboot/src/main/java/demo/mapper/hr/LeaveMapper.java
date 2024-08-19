package demo.mapper.hr;

import demo.entity.LeaveInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface LeaveMapper {
    @Select("select a.a0188 from V_a01_forbetter a where a.A0190 = #{employeeID}")
    int getHrID(@Param("employeeID") String employeeID);

    @Select("select a.a0188 from V_a01_forbetter a where a.A0190 = 'A0117856'")
    int getid();
}
