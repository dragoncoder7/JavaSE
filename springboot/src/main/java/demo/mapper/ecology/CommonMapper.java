package demo.mapper.ecology;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommonMapper {
    //获得请假类型数字对应文本值
    @Select("""
            select (case
                     when c.selectname like '~`~`7%' then
                      SUBSTR(c.selectname,
                             INSTR(c.selectname, '7') + 1,
                             INSTR(c.selectname, '`', INSTR(c.selectname, '7') + 1) -
                             INSTR(c.selectname, '7') - 1)
                     else
                      c.selectname
                   end) as selectname
              from workflow_base a, workflow_billfield b,workflow_selectitem c
             where a.id = #{workflowId}
               and a.isvalid = 1
               and a.formid = b.billid
               and b.fieldname = #{fieldName}
               and c.fieldid = b.id
               and c.selectvalue = #{value}""")
    String getMappingValue(@Param("workflowId") int workflowId,@Param("fieldName") String fieldName,@Param("value") String value);

    /**
     * 通过流程requestid获取流程当前审批状态
     * @param requestId
     * @return 0 创建节点 // 1 审批中 // 2 提醒 // 3 归档
     */
    @Select("select * from workflow_requestbase a where a.requestid = #{requestId}")
    int getWorkflowStatus(@Param("requestId") int requestId);
}
