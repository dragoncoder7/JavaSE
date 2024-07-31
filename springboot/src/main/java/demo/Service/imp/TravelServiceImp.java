package demo.Service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.HttpsUtils.Https;
import demo.Service.TokenService;
import demo.Service.TravelService;
import demo.entity.TravelInfo;
import demo.mapper.TravelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TravelServiceImp implements TravelService {

    @Value("${ecology.huilianyi.environment}")
    private String APP_ENVIRONMENT;
    public static final Logger LOGGER = LoggerFactory.getLogger(TravelServiceImp.class);
    TravelMapper travelMapper;

    TokenService tokenService;

    Https https;

    @Autowired
    public TravelServiceImp(TravelMapper travelMapper, TokenService tokenService, Https https) {
        // 默认构造器
        this.travelMapper = travelMapper;
        this.tokenService = tokenService;
        this.https = https;
    }


    @Override
    public String createTravelApply(int requestId) {
        String Suffix = "/api/open/travelApplication/create";
        TravelInfo travelInfo = getTravelInfo(requestId);

        String initiated = initdata();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode;
        String res;

        try {
            rootNode = objectMapper.readTree(initiated);
            ObjectNode employeeID = (ObjectNode) rootNode.get("applicant");
            employeeID.put("employeeID",travelInfo.getEmployeeID());
            ArrayNode customFormValuesArray = (ArrayNode) rootNode.get("custFormValues");
            for (JsonNode node : customFormValuesArray) {
                ObjectNode objectNode = (ObjectNode) node;
                String messageKey = objectNode.get("messageKey").asText();
                switch (messageKey) {
                    case "select_company" -> objectNode.put("value", travelInfo.getCompanyOID());
                    case "select_cost_center" -> objectNode.put("value", travelInfo.getDepartmentOID());
                    case "cust_list" -> objectNode.put("value", travelInfo.getTravelType());
                    case "start_date" -> objectNode.put("value", travelInfo.getStart_date());
                    case "end_date" -> objectNode.put("value", travelInfo.getEnd_date());
                    case "city" -> objectNode.put("value", travelInfo.getCity());
                    case "select_participant" -> objectNode.put("value", travelInfo.getEmployeeID());
                    case "input" -> objectNode.put("value", travelInfo.getParticipant());
                    case "title" -> objectNode.put("value", travelInfo.getBusinessReason());
                    case "number" -> objectNode.put("value", 0);
                    case "select_user" -> objectNode.put("value", travelInfo.getWorkAgent());
                    case "attachment" -> objectNode.put("value", String.valueOf(travelInfo.getAttachment()));
                    default -> {
                    }
                }
            }

            LOGGER.info("这里是更新后的数据：\n" + customFormValuesArray);

            res = https.Post(APP_ENVIRONMENT + Suffix, objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode));

            LOGGER.info(res);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    @Override
    public TravelInfo getTravelInfo(int requestId) {
        //初始化获得OA表单信息
        TravelInfo travelInfo = travelMapper.getTravelInfo(requestId);

        //调用汇联易人员接口 补全汇联易公司、部门、人员oid信息
        LOGGER.info(String.valueOf(travelInfo));
        String Suffix = "/api/open/user/detail/"+travelInfo.getEmployeeID();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(APP_ENVIRONMENT+Suffix);

        //发送请求获得数据
        String response = https.Get("",uriComponentsBuilder);
        //LOGGER.info(response);
        JsonNode jsonNode;

        try {
            ObjectMapper objectMapper =  new ObjectMapper();
            jsonNode = objectMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        travelInfo.setCompanyOID(jsonNode.get("companyOID").asText());
        travelInfo.setDepartmentOID(jsonNode.get("departmentOID").asText());
        travelInfo.setCompanyCode(jsonNode.get("companyCode").asInt());
        travelInfo.setFormOID(travelInfo.getTravelType() == 0 ? "A：国内" : "B：国外");//根据差旅类型映射差旅申请单-国内/外
        LOGGER.info("补全后的travelInfo：\n"+ travelInfo);
        return travelInfo;
    }

    public String test(){
        LOGGER.info(travelMapper.getGH(6433730));
        return travelMapper.getGH(6433730);
    }
    public String initdata(){
        return """
                {
                    "applicant": {
                        "employeeID": ""
                    },
                    "currencyCode": "CNY",
                    "companyCode": "10",
                    "custFormValues": [
                        {
                            "fieldOID": "4b13b9a8-f58b-4435-9441-e020f3948238",
                            "messageKey": "select_company",
                            "value": ""
                        },
                        {
                            "messageKey": "select_cost_center",
                            "fieldOID": "e815c050-57fc-4eea-b2d6-2b445a98059c",
                            "fieldName": "部门",
                            "value": "",
                            "required": false
                        },
                        {
                            "fieldName": "出差类型",
                            "fieldType": "CUSTOM_ENUMERATION",
                            "fieldOID": "13c7d60c-3af0-49ce-88be-0f41d811aa54",
                            "messageKey": "cust_list",
                            "value": ""
                        },
                        {
                            "messageKey": "start_date",
                            "fieldOID": "390f6601-4d28-46c3-a93a-e057faca1175",
                            "name": "2024-07-08T16:00:00Z",
                            "value": ""
                        },
                        {
                            "fieldOID": "b98318d1-906b-49aa-9e86-2bca8f280808",
                            "name": "2024-07-16T15:59:00Z",
                            "value": "",
                            "messageKey": "end_date"
                        },
                        {
                            "fieldOID": "241ed88f-96fb-4209-8c29-fc9c8ba1459e",
                            "fieldName": "出差城市",
                            "name": "CHN044019000",
                            "value": "",
                            "messageKey": "city"
                        },
                        {
                            "fieldOID": "4e51e534-75fa-48a9-b7b7-7313f4fa4154",
                            "fieldName": "参与人员（系统控件）",
                            "messageKey": "select_participant",
                            "value": ""
                        },
                        {
                            "fieldOID": "45c7335f-1922-4a69-ae10-d871e95d40d0",
                            "fieldName": "参与人",
                            "fieldType": "TEXT",
                            "fieldTypeId": 101,
                            "name": "毛云龙 张欢欢",
                            "value": "",
                            "messageKey": "input"
                        },
                        {
                            "fieldOID": "687c8119-061a-4203-b4ab-5d0e35bf69a7",
                            "fieldName": "出差事由",
                            "messageKey": "title",
                            "value": ""
                        },
                        {
                            "fieldOID": "cb777a1a-fea0-4092-a88f-49320d0c3f05",
                            "fieldName": "预定机票",
                            "messageKey": "cust_list",
                            "value": "1"
                        },
                        {
                            "fieldOID": "eca7476b-6a28-47ab-b077-304577a5a0f1",
                            "fieldName": "预支旅费",
                            "value": "",
                            "messageKey": "number"
                        },
                        {
                            "fieldName": "工作代理人",
                            "fieldOID": "dd1cc8e2-eb54-419e-84fb-cd26a2361c2e",
                            "value": "",
                            "messageKey": "select_user"
                        },
                        {
                            "fieldName": "附件",
                            "fieldOID": "fd587576-6cf5-4503-94a5-b1fe17b81b9c",
                            "messageKey": "attachment",
                            "value": "[{\\"attachmentOID\\":\\"71c5f586-cce5-4028-b654-9418fb653bfe\\"}]"
                        },
                        {
                            "messageKey": "input",
                            "fieldName": "项目号说明",
                            "fieldOID": "ada4cc79-51af-47f2-a2af-f20dec5c89ad",
                            "value": ""
                        }
                    ],
                    "formOID": "f3eb46e7-b133-49ca-885f-31eac722b38c",
                    "formType": 2001,
                    "status": 1003,
                    "travelApplication": {},
                    "type": 1002
                }""";
    }
}
