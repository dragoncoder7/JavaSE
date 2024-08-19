package demo.Service.imp;

import demo.entity.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import demo.Utils.Https;
import demo.Service.TokenService;
import demo.Service.TravelService;
import demo.entity.TravelInfo;
import demo.mapper.ecology.TravelMapper;
import demo.mapper.hr.LeaveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Iterator;
import java.util.List;


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
    public Message createTravelApply(int requestId) {
        String Suffix = "/api/open/travelApplication/create";

        TravelInfo travelInfo = getTravelInfo(requestId);

        if (travelInfo == null){
            LOGGER.info("流程发起人没有汇联易账号！");
            return new Message("-1","failure","流程发起人没有汇联易账号！无法创建汇联易单据，请先申请汇联易账号后重新提交该单据。");
        }

        if (!travelInfo.isActivated() || travelInfo.getStatus().equals("1003")){
            LOGGER.info("汇联易账号状态为离职状态或者未激活:"+travelInfo.getEmployeeID());
            return new Message("-1","failure","流程发起人汇联易账号状态为离职状态或者未激活，无法创建汇联易单据，请先激活或者恢复汇联易账号后重新提交该单据。");
        }

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode requestNode;

        String res,businessCode;

        try {
            LOGGER.info("\n"+initiated());

            //请求JSON信息
            requestNode = objectMapper.readTree(initiated());

            //自定义数据赋值

            //头数据赋值
            ObjectNode employeeID = (ObjectNode) requestNode.get("applicant");
            employeeID.put("employeeID",travelInfo.getEmployeeID());

            ObjectNode companyID = (ObjectNode) requestNode;
            companyID.put("companyCode",travelInfo.getCompanyCode());


            ArrayNode customFormValuesArray = (ArrayNode) requestNode.get("custFormValues");
            for (JsonNode node : customFormValuesArray) {
                ObjectNode objectNode = (ObjectNode) node;
                String fieldCode = objectNode.get("fieldCode").asText();
                switch (fieldCode) {
                    case "company":
                        objectNode.put("valueCode", travelInfo.getCompanyCode()); // 公司
                        break;
                    case "department":
                        objectNode.put("value", travelInfo.getDepartmentID().split("_")[0]); // 部门
                        break;
                    case "travelType":
                        objectNode.put("valueCode", travelInfo.getTravelType()); // 出差类型
                        break;
                    case "isOrderAirTicket":
                        objectNode.put("valueCode", travelInfo.getIsOrderAirTicket()); // 是否预订机票
                        break;
                    case "start_date":
                        objectNode.put("value", travelInfo.getStart_date().split(" ")[0]); // 出差开始时间
                        break;
                    case "end_date":
                        objectNode.put("value", travelInfo.getEnd_date().split(" ")[0]); // 出差结束时间
                        break;
                    case "city":
                        objectNode.put("value", travelInfo.getCity()); // 出差地点
                        break;
                    // case "select_participant":
                    //     objectNode.put("value", travelInfo.getEmployeeID()); //
                    //     break;
                    case "participant":
                        objectNode.put("value", travelInfo.getParticipant()); // 出差参与人
                        break;
                    case "businessReason":
                        objectNode.put("value", travelInfo.getBusinessReason()); // 出差事由
                        break;
                    case "TravelFee":
                        objectNode.put("value", travelInfo.getTravelFee()); // 出差费用
                        break;
                    case "WorkAgent":
                        objectNode.put("valueCode", travelInfo.getWorkAgent());
                        break;
                    case "file":
                        objectNode.put("value", String.valueOf(travelInfo.getAttachment()));
                        break;
                    // case "projectNo":
                    //     objectNode.put("value", travelInfo.getProjectNo().split("_")[0]); // 120002
                    //     break;
                    case "projectNo":
                        objectNode.put("value", 120002); // 测试环境只有三个项目 直接写死
                        break;
                    case "projectNoDesc":
                        objectNode.put("value", travelInfo.getProjectNoDesc());
                        break;
                    default:
                        break;
                }

            }

            LOGGER.info("这里是更新后的数据：\n" + requestNode);

            //调用接口创建汇联易单据
            res = https.Post(APP_ENVIRONMENT + Suffix, objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestNode));

            LOGGER.info(res);

            JsonNode responseNode = objectMapper.readTree(res);

            if (responseNode.get("businessCode").asText() == null){
                return new Message("0","failure", responseNode.asText());
            }
            businessCode = responseNode.get("businessCode").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //return res;
        Message message = new Message("200","success", businessCode);

        LOGGER.info(String.valueOf(message));

        return message;
    }

    @Override
    public TravelInfo getTravelInfo(int requestId) {
        //初始化获得OA表单信息
        TravelInfo travelInfo = travelMapper.getTravelInfo(requestId);

        //调用汇联易人员接口 补全汇联易公司、部门、人员oid、状态、账号是否已激活等信息
        LOGGER.info(String.valueOf(travelInfo));
        String response = getHeliosPeopleInfo(travelInfo.getEmployeeID());

        //获取汇联易参与人
        List<String> participantslist = travelMapper.getParticipants(requestId);
        travelInfo.setParticipant(String.join(",",participantslist));

        //获取汇联易工作代理人
        List<String> workAgentlist = travelMapper.getWorkAgents(requestId);
        for (Iterator<String> iterator = workAgentlist.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            if (!isHasHeliosAccount(getHeliosPeopleInfo(s))) {
                iterator.remove();  // 使用 Iterator 的 remove 方法来删除元素
            }
        }
        travelInfo.setWorkAgent(String.join(",",workAgentlist));

        if (!isHasHeliosAccount(response)){
            LOGGER.info("员工不存在，该人员没有汇联易账号");
            return null;
        }

        //LOGGER.info(response);
        //需要添加逻辑判断 是否正常获取了数据 如果没有 进行相应的处理
        JsonNode jsonNode;

        try {
            ObjectMapper objectMapper =  new ObjectMapper();
            jsonNode = objectMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        travelInfo.setStatus(jsonNode.get("status").asText());//获取账号属性 1001 在职 1003 离职（无法创建单据）
        travelInfo.setActivated(jsonNode.get("activated").asBoolean());//获得账号是否已经激活
        travelInfo.setCompanyCode(jsonNode.get("companyCode").asInt());
        travelInfo.setTravelType(travelInfo.getTravelType().equals("0") ? "0" : "1");//根据差旅类型映射差旅申请单-国内/外
        LOGGER.info("补全后的travelInfo：\n"+ travelInfo);
        return travelInfo;
    }
    @Override
    public String getHeliosPeopleInfo(String EmployeeID){

        String Suffix = "/api/open/user/detail/"+EmployeeID;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(APP_ENVIRONMENT+Suffix);

        //发送请求获得数据
        return https.Get("",uriComponentsBuilder);

    }
    @Override
    public boolean isHasHeliosAccount(String responseBody){
        try {
            ObjectMapper objectMapper =  new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            if (jsonNode.get("errorCode") == null){
                LOGGER.info(responseBody);
                return true;
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public String test(){
        LOGGER.info(travelMapper.getGH(6433730));
        return travelMapper.getGH(6433730);
    }

    private String initiated() {
        return "{\n" +
                "    \"applicant\": {\n" +
                "        \"employeeID\": \"\"\n" +
                "    },\n" +
                "    \"currencyCode\": \"CNY\",\n" +
                "    \"companyCode\": \"\",\n" +
                "    \"custFormValues\": [\n" +
                "        {\n" +
                "            \"fieldCode\": \"company\",\n" +
                "            \"messageKey\": \"select_company\",\n" +
                "            \"valueCode\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"department\",\n" +
                "            \"messageKey\": \"select_cost_center\",\n" +
                "            \"value\": \"\",\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"travelType\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"valueCode\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"start_date\",\n" +
                "            \"messageKey\": \"start_date\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"end_date\",\n" +
                "            \"messageKey\": \"end_date\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"city\",\n" +
                "            \"messageKey\": \"city\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"participant\",\n" +
                "            \"messageKey\": \"input\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"businessReason\",\n" +
                "            \"messageKey\": \"title\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"isOrderAirTicket\",\n" +
                "            \"messageKey\": \"cust_list\",\n" +
                "            \"valueCode\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"TravelFee\",\n" +
                "            \"messageKey\": \"number\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"WorkAgent\",\n" +
                "            \"messageKey\": \"select_user\",\n" +
                "            \"valueCode\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"file\",\n" +
                "            \"messageKey\": \"attachment\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"projectNoDesc\",\n" +
                "            \"messageKey\": \"input\",\n" +
                "            \"value\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"fieldCode\": \"projectNo\",\n" +
                "            \"messageKey\": \"select_cost_center\",\n" +
                "            \"value\": \"\"\n" +
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
