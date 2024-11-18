package demo.entity;

import lombok.Data;

/**
 * 加班
 */
@Data
public class OverWorker {
    private int id;
    //姓名
    private String name;

    //工号
    private String employeeID;

    //加班类型
    private int type;

    //加班开始时间
    private String startTime;

    //加班结束时间
    private String endTime;

    //加班事由
    private String reason;

    //是否调休
    private int isChange;

    //班次
    private int turn;

    //加班时长
    private float length;

    //加班日期
    private String time;

    private String workflowNo;
}
