package demo.Service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.Service.TokenService;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class TokenServiceImp implements TokenService {

    public static final Logger LOGGER = LoggerFactory.getLogger(TokenServiceImp.class);

    @Value("${ecology.huilianyi.appkey}")
    private String APP_KEY;

    @Value("${ecology.huilianyi.appsecret}")
    private String APP_SECRET;

    @Value("${ecology.huilianyi.environment}")
    private String APP_ENVIRONMENT;

    private String token = "";

    private long tokenValiditySeconds;

    private long tokenExpiryTime;

    private long tokenAcquiredTime;

    @Override
    public String toString() {
        return "TravelServiceImp{" +
                "APP_KEY='" + APP_KEY + '\'' +
                ", APP_SECRET='" + APP_SECRET + '\'' +
                ", APP_ENVIRONMENT='" + APP_ENVIRONMENT + '\'' +
                ", token='" + token + '\'' +
                ", tokenValiditySeconds=" + tokenValiditySeconds +
                ", tokenExpiryTime=" + tokenExpiryTime +
                ", tokenAcquiredTime=" + tokenAcquiredTime +
                '}';
    }

    private String fetchNewToken() {

        //设置头信息
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        String authStr = APP_KEY.concat(":").concat(APP_SECRET);
        String authStrEnc = new String(Base64.encodeBase64(authStr.getBytes()));
        httpHeaders.set("Authorization", "Basic ".concat(authStrEnc));
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        //设置请求体
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("scope", "write");
        HttpEntity<MultiValueMap<String, String>> httpEntity =  new HttpEntity<>(formData, httpHeaders);

        //发送请求信息获取汇联易token
        ResponseEntity<String> exchange = restTemplate.exchange
                (
                        APP_ENVIRONMENT.concat("/oauth/token"),
                        HttpMethod.POST,
                        httpEntity,
                        String.class
                );

        LOGGER.info(exchange.getBody());

        //解析结果获得access_token 并且设置token获取时间为当前时间 更新token有效时长
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(exchange.getBody());
        } catch (Exception e){
            LOGGER.info(e.toString());
        }
        if (jsonNode == null){
            return "failure";
        }
        tokenValiditySeconds = jsonNode.get("expires_in").asLong();//获得token有效期 单位为秒
        tokenAcquiredTime = System.currentTimeMillis();//token获得时间

        return jsonNode.get("access_token").asText();
    }

    @Override
    public String getToken() {
        if (token == null || isTokenExpired() || token.isEmpty()) {
            LOGGER.info("token有效期已过！重新调用接口获取最新token");
            // 假设 fetchNewToken() 是一个方法，它从外部服务获取新 token
            this.token = fetchNewToken();
            this.tokenExpiryTime = System.currentTimeMillis() + getTokenExpiryDuration() * 1000;
        }
        return this.token;
    }

    private boolean isTokenExpired() {
        return System.currentTimeMillis() > tokenExpiryTime;
    }



    @Override
    public String data() {
        return toString();
    }

    private long getTokenExpiryDuration() {
        // 你可以设置 token 的有效期，比如 1 小时 (3600000 毫秒)
        return tokenValiditySeconds;
    }
}
