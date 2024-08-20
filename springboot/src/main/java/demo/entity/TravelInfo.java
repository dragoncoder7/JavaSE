package demo.entity;

import lombok.Data;
import java.util.List;


@Data
public class TravelInfo {
    //工号
    private String employeeID;

    //出差开始时间
    private String start_date;

    //出差结束时间
    private String end_date;

    //出差类型
    private String travelType;

    //出差事由
    private String businessReason;

    //是否需要预订机票
    private int isOrderAirTicket;

    //工作代理人
    private String WorkAgent;

    //出差城市
    private String city;

    //参与人
    private String participant;

    //OA附件id
    private String attachmentID;

    //项目号
    private String projectNo;

    //项目号详细说明
    private String projectNoDesc;

    //汇联易公司代码 数据来源：OA
    private int companyCode = 0;

    //汇联易部门ID 数据来源：ERP
    private String departmentID = null;

    //出差费用
    private double TravelFee;

    //汇联易账号状态
    private String status;

    //汇联易账号是否已激活
    private boolean isActivated;

    //附件列表
    private List<Attachment> attachments;

    private String errorMessage = "";
}
