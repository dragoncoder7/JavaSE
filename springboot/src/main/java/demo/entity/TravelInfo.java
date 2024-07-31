package demo.entity;

import lombok.Data;
import java.io.File;


@Data
public class TravelInfo {
    private String employeeID;

    private String start_date;

    private String end_date;

    private int travelType;

    private String businessReason;

    private int isOrderAirTicket;

    private String WorkAgent;

    private String city;

    private String participant;

    private File attachment = null;

    private String formOID = null;

    private int companyCode = 0;

    private String companyOID = null;

    private String departmentOID = null;

}
