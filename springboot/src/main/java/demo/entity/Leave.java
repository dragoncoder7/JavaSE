package demo.entity;

import lombok.Data;

/**
 * 科伦特请假
 */
@Data
public class Leave {
    private String name;

    private String employeeID;

    private String startTime;

    private String endTime;

    private String type;

    private String reason;

    private String workflowID;

    private int length;

    private String workflowNo;
}
