package demo.Https;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.time.Duration;
@Component
public class HTTP {

    public static final Logger LOGGER = LoggerFactory.getLogger(HTTP.class);


    private static final RestTemplate restTemplate = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000 * 60))//设置连接超时1分钟
            .setReadTimeout(Duration.ofMillis(1000 * 60))//设置读取数据超时1分钟
            .build();
    public String Get(String body, String url){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        LOGGER.info(responseEntity.getBody());

        return responseEntity.getBody();
    }
}
