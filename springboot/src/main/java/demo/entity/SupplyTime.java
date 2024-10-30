package demo.entity;

import lombok.Data;

/**
 * 补卡实体 姓名 工号 漏卡原因 补卡时间
 */
@Data
public class SupplyTime {
    private String username;

    private String employeeID;

    private String reason;//通过字段映射获得对应值

    private String time;
}
