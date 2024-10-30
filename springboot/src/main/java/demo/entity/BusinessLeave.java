package demo.entity;

import lombok.Data;

/**
 * 出差
 */
@Data
public class BusinessLeave {

    private String employeeID;

    private String username;

    private String startTime;

    private String endTime;

    private int type;

    private float hours;

    private String reason;

    private String workflowNo;
}
