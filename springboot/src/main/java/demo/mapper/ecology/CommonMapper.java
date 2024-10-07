package demo.mapper.ecology;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommonMapper {
    //获得请假类型数字对应文本值
    @Select("select (case\n" +
            "         when c.selectname like '~`~`7%' then\n" +
            "          SUBSTR(c.selectname,\n" +
            "                 INSTR(c.selectname, '7') + 1,\n" +
            "                 INSTR(c.selectname, '`', INSTR(c.selectname, '7') + 1) -\n" +
            "                 INSTR(c.selectname, '7') - 1)\n" +
            "         else\n" +
            "          c.selectname\n" +
            "       end) as selectname\n" +
            "  from workflow_base a, workflow_billfield b,workflow_selectitem c\n" +
            " where a.id = #{workflowId}\n" +
            "   and a.isvalid = 1\n" +
            "   and a.formid = b.billid\n" +
            "   and b.fieldname = #{fieldName}\n" +
            "   and c.fieldid = b.id\n" +
            "   and c.selectvalue = #{value}")
    String getMappingValue(@Param("workflowId") int workflowId,@Param("fieldName") String fieldName,@Param("value") String value);
}
