package demo.Service.imp;

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

import static demo.HttpsUtils.Https.Get;

@Service
public class TravelServiceImp implements TravelService {

    @Value("${ecology.huilianyi.environment}")
    private String APP_ENVIRONMENT;
    public static final Logger LOGGER = LoggerFactory.getLogger(TravelServiceImp.class);
    TravelMapper travelMapper;

    TokenService tokenService;

//    @Autowired
//    public TravelServiceImp(TravelMapper travelMapper, TokenService tokenService) {
//        // 默认构造器
//        this.travelMapper = travelMapper;
//        this.tokenService = tokenService;
//    }


    @Override
    public String createTravelApply(int requestId) {
        String Suffix = "/api/open/travelApplication/create";
        TravelInfo travelInfo = getTravelInfo(requestId);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
//                .fromUriString(APP_ENVIRONMENT+Suffix)
//                ;
//        httpHeaders.set("Authorization","Bear "+tokenService.getToken());
        return String.valueOf(travelInfo);
    }

    @Override
    public TravelInfo getTravelInfo(int requestId) {
        //初始化获得OA表单信息
        //TravelInfo travelInfo = travelMapper.getTravelInfo(requestId);
        TravelInfo travelInfo = new TravelInfo();
        travelInfo.setEmployeeID("A0002045");
        //调用汇联易人员接口 补全汇联易公司、部门、人员oid信息
        LOGGER.info(String.valueOf(travelInfo));
        String Suffix = "/api/open/user/detail/"+travelInfo.getEmployeeID();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization","Bearer "+tokenService.getToken());
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(APP_ENVIRONMENT+Suffix);
        String response = Get("",httpHeaders,uriComponentsBuilder);
        LOGGER.info(response);
        ObjectMapper objectMapper =  new ObjectMapper();
        try {
            objectMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return travelInfo;
    }

    public String test(){
        LOGGER.info(travelMapper.getTravelInfo(9002074).toString());
        return travelMapper.getTravelInfo(9002074).toString();
    }
}
