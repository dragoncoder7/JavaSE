package demo.entity;

import lombok.Data;

/**
 * 奖惩
 */
@Data
public class RewardPunish {

    private String employeeID;

    private String username;

    private String requestTime;

    private float money;

    private String reason;

    private int type;

    private String punishTime;

    private String remark;

    private String workflowNo;
}
