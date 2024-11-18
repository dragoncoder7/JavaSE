package demo.entity;

import lombok.Data;

/**
 * 销假
 */
@Data
public class ResetLeave {
    private String name;

    private String employeeID;

    private String startTime;

    private String endTime;

    private String type;

    private String reason;

    private String workflowID;

    private float length;

    private String workflowNo;
}
