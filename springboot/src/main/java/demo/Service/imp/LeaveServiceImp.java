package demo.Service.imp;

import demo.DataSource.JdbcTemplateConfig;
import demo.Service.LeaveService;
import demo.entity.LeaveInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class LeaveServiceImp implements LeaveService {
    public static final Logger LOGGER = LoggerFactory.getLogger(LeaveServiceImp.class);

    @Resource
    private JdbcTemplateConfig jdbcTemplateConfig;

    @Override
    public int push(LeaveInfo leaveInfo) {

        JdbcTemplate hr = jdbcTemplateConfig.hrJdbcTemplate();

        LOGGER.info(leaveInfo.toString());

        return callHrProcedure(hr, leaveInfo);

    }

    /**
     * 调用HR系统存储过程
     *
     * @param hr HR系统数据库连接
     * @param leaveInfo 请假信息
     * @return 存储过程执行结果
     */
    public int callHrProcedure(JdbcTemplate hr, LeaveInfo leaveInfo) {
        String procedureCall = "{call pIns_K20(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; // 9个输入参数 + 1个输出参数
        //{call pIns_K20(?,?,?,?,?,?,?,?,?,?)}
        //{call pIns_K20('28802', '出差', '2024-08-15 08:00', '2024-08-15 17:30', '天', '1', '', 'ehr审核', 'MA08-202408160038')}
        // 定义输入和输出参数
        List<SqlParameter> parameters = Arrays.asList(
                new SqlParameter(Types.INTEGER),  // param1 (HR人员id)
                new SqlParameter(Types.VARCHAR),  // param2 (请假类型)
                new SqlParameter(Types.VARCHAR),  // param3 (出差时间起)
                new SqlParameter(Types.VARCHAR),  // param4 (出差时间止)
                new SqlParameter(Types.INTEGER),  // param5 (出差时长)
                new SqlParameter(Types.VARCHAR),  // param6 (出差单位)
                new SqlParameter(Types.VARCHAR),  // param7 (出差事由)
                new SqlParameter(Types.VARCHAR),  // param8 (出差单审批人)
                new SqlParameter(Types.VARCHAR),  // param9 (OA单据号)
                new SqlOutParameter("status", Types.INTEGER) // 输出参数
        );

        // 使用 JdbcTemplate 调用存储过程
        Map<String, Object> result = hr.call(
                connection -> {
                    CallableStatement callableStatement = connection.prepareCall(procedureCall);

                    /*[人员ID],[假期类型],[请假开始],[请假结束],[时间单位],[时间长度],[请假原因],[审批者]*/
                    // 设置输入参数
                    callableStatement.setInt(1, leaveInfo.getId());
                    callableStatement.setString(2, leaveInfo.getType());
                    callableStatement.setString(3, leaveInfo.getStartTime());
                    callableStatement.setString(4, leaveInfo.getEndTime());
                    callableStatement.setString(5, leaveInfo.getUnit());
                    callableStatement.setString(6, leaveInfo.getLength());
                    callableStatement.setString(7, leaveInfo.getReason());
                    callableStatement.setString(8, leaveInfo.getApprove());
                    callableStatement.setString(9, leaveInfo.getOaWorkflowNo());

                    // 注册输出参数
                    callableStatement.registerOutParameter(10, Types.INTEGER); // 输出参数在第10位

                    return callableStatement;
                },
                parameters
        );

        // 获取并返回输出参数的值
        return (int) result.get("status"); // 获取存储过程执行后的输出参数
    }

}
