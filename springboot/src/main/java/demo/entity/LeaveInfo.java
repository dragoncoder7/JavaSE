package demo.entity;

import lombok.Data;

/**
 * 出差申请单实体
 */
@Data
public class LeaveInfo {

    //姓名
    private String name;

    //工号
    private String employeeID;

    //出差开始时间
    private String startTime;

    //出差截止时间
    private String endTime;

    //出差时长
    private String length;

    //出差事由
    private String reason;

    //OA流程编号
    private String OaWorkflowNo;

    //Hr人员Id
    private int id;

    //出差时间单位 固定 天
    private String unit = "天";

    //出差审批人
    private String approve = "ehr";

    //请假类型
    private String type = "出差";
}
