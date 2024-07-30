package demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.Service.TokenService;
import demo.Service.TravelService;
import demo.Service.imp.TravelServiceImp;
import demo.entity.TravelInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class TAController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TAController.class);

    private final TokenService tokenService;
    private final TravelService travelService ;

    @Autowired
    public TAController(TravelService travelService, TokenService tokenService) {
        // 默认构造器
        this.travelService = travelService;
        this.tokenService = tokenService;
    }





    public static void main(String[] args) {
//        TravelInfo travelBean = TravelInfo.builder()
//                .travelType("")
//                .build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test(){
//        String token = tokenService.getToken();
//        if (token == null || token.equals("failure")){
//            return "failure";
//        }else
//            return tokenService.toString();
        return travelService.test();
    }
    @RequestMapping(value = "/travelApplication/create", method = RequestMethod.POST, consumes = "application/json",produces = "application/json; charset=UTF-8")
    public void createTravelApply(@Param("requestId") Integer requestId) throws JsonProcessingException {
        TravelInfo travelInfo = null;
        String initiated = initdata();
        LOGGER.info(travelService.createTravelApply(requestId));
        //ResultSet resultSet = travelMapper.getTravelInfoInfo(requestId);
//        while (resultSet.next()){
//            travelBean = TravelInfo.builder()
//                    .employeeID(resultSet.getString("gh"))
//                    .start_date(resultSet.getDate("qsrq1"))
//                    .end_date(resultSet.getDate("jzrq1"))
//                    .travelType(resultSet.getString("cclx"))
//                    .businessReason(resultSet.getString("sy"))
//                    .isOrderAirTicket(resultSet.getInt("ydjp"))
//                    .WorkAgent(resultSet.getString("zwdlr"))
//                    .city(resultSet.getString("xxdd"))
//                    .participant(resultSet.getString("ccry"))
//                    .build();
//            }
        //select gh,qsrq1,jzrq1,cclx,sy,ydjp,zwdlr,xxdd,ccry from fomrtable_main_17 where requestid = #{requestId}
        LOGGER.info(String.valueOf(travelInfo));
        System.out.println(initiated);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(initiated);


        //先写思路  先判断工号是不是跟HR的一致 一致了 先推hr
        // 再判断有没有推到过汇联易 把单号回显给oa 如果没有 就调用这个程序 去
    }
    public String initdata(){
        return "{\n" +
                "    \"applicant\": {\n" +
                "        \"employeeID\": \"A0117856\"\n" +
                "    },\n" +
                "    \"currencyCode\": \"CNY\",\n" +
                "    \"companyCode\": \"10\",\n" +
                "    \"custFormValues\": [\n" +
                "        {\n" +
                "            \"fieldOID\": \"4b13b9a8-f58b-4435-9441-e020f3948238\",\n" +
                "            \"messageKey\": \"select_company\",\n" +
                "            \"value\": \"4be6a6ca-8705-4c0d-ab8f-bfa229df5bf0\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"select_cost_center\",\n" +
                "            \"fieldOID\": \"e815c050-57fc-4eea-b2d6-2b445a98059c\",\n" +
                "            \"fieldName\": \"部门\",\n" +
                "            \"value\": \"\",\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"出差类型\",\n" +
                "            \"fieldType\": \"CUSTOM_ENUMERATION\",\n" +
                "            \"fieldOID\": \"13c7d60c-3af0-49ce-88be-0f41d811aa54\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"value\": \"01\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"start_date\",\n" +
                "            \"fieldOID\": \"390f6601-4d28-46c3-a93a-e057faca1175\",\n" +
                "            \"name\": \"2024-07-08T16:00:00Z\",\n" +
                "            \"value\": \"2024-07-19\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"b98318d1-906b-49aa-9e86-2bca8f280808\",\n" +
                "            \"name\": \"2024-07-16T15:59:00Z\",\n" +
                "            \"value\": \"2024-07-26\",\n" +
                "            \"messageKey\": \"end_date\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"241ed88f-96fb-4209-8c29-fc9c8ba1459e\",\n" +
                "            \"fieldName\": \"出差城市\",\n" +
                "            \"name\": \"CHN044019000\",\n" +
                "            \"value\": \"CHN044019000\",\n" +
                "            \"messageKey\": \"city\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"4e51e534-75fa-48a9-b7b7-7313f4fa4154\",\n" +
                "            \"fieldName\": \"参与人员（系统控件）\",\n" +
                "            \"messageKey\": \"select_participant\",\n" +
                "            \"value\": \"A0117856\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"45c7335f-1922-4a69-ae10-d871e95d40d0\",\n" +
                "            \"fieldName\": \"参与人\",\n" +
                "            \"fieldType\": \"TEXT\",\n" +
                "            \"fieldTypeId\": 101,\n" +
                "            \"name\": \"毛云龙 张欢欢\",\n" +
                "            \"value\": \"毛云龙\",\n" +
                "            \"messageKey\": \"input\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"687c8119-061a-4203-b4ab-5d0e35bf69a7\",\n" +
                "            \"fieldName\": \"出差事由\",\n" +
                "            \"messageKey\": \"title\",\n" +
                "            \"value\": \"出差深圳长盈精密~\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"cb777a1a-fea0-4092-a88f-49320d0c3f05\",\n" +
                "            \"fieldName\": \"预定机票\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"value\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldOID\": \"eca7476b-6a28-47ab-b077-304577a5a0f1\",\n" +
                "            \"fieldName\": \"预支旅费\",\n" +
                "            \"value\": \"50000.00\",\n" +
                "            \"messageKey\": \"number\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"工作代理人\",\n" +
                "            \"fieldOID\": \"dd1cc8e2-eb54-419e-84fb-cd26a2361c2e\",\n" +
                "            \"value\": \"4d0e7d7f-096d-4b3e-b627-dfaaaec15e7d\",\n" +
                "            \"messageKey\": \"select_user\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldName\": \"附件\",\n" +
                "            \"fieldOID\": \"fd587576-6cf5-4503-94a5-b1fe17b81b9c\",\n" +
                "            \"messageKey\": \"attachment\",\n" +
                "            \"value\": \"[{\\\"attachmentOID\\\":\\\"71c5f586-cce5-4028-b654-9418fb653bfe\\\"}]\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"messageKey\": \"input\",\n" +
                "            \"fieldName\": \"项目号说明\",\n" +
                "            \"fieldOID\": \"ada4cc79-51af-47f2-a2af-f20dec5c89ad\",\n" +
                "            \"value\": \"项目号说明123\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"formOID\": \"f3eb46e7-b133-49ca-885f-31eac722b38c\",\n" +
                "    \"formType\": 2001,\n" +
                "    \"status\": 1003,\n" +
                "    \"travelApplication\": {},\n" +
                "    \"type\": 1002\n" +
                "}";
    }


}
