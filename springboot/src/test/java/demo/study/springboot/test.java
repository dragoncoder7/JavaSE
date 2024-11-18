package demo.study.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@SpringBootTest
public class test {
    private static final Logger logger = LoggerFactory.getLogger(test.class);

    @Test
    public void abed(){
        permissionRemove("A0117856");
    }
    public void permissionRemove(String employeeID){

        String url = "http://cy.ubooking.cn/index/api/toDeleteEmployee";

        long currentTimeMillis = System.currentTimeMillis() / 1000;//获得当前时间戳

        String originalString = "key=ZqhFBP3kJZhc4IewlIAh&timestamp="+currentTimeMillis+"&secret=wj$hExL1";

        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalString.getBytes());
            byte[] digest = md.digest();

            // 将 byte 数组转为 16 进制字符串

            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            logger.info("Original: " + originalString);
            logger.info("MD5 Hash: " + sb.toString().toUpperCase());

        } catch (NoSuchAlgorithmException e) {
            logger.info(String.valueOf(e));
        }

        // 构建请求体
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("key", "ZqhFBP3kJZhc4IewlIAh");         //盐值
        body.add("timestamp", currentTimeMillis);           //以秒为单位的时间戳
        body.add("employeeCode", employeeID);                 //对应人员
        body.add("signature", sb.toString().toUpperCase()); //MD5码签名
        logger.info(body.toString());

        //配置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        //调用接口
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                url,
                requestEntity,
                String.class
        );
        logger.info(responseEntity.getBody());
    }
}
