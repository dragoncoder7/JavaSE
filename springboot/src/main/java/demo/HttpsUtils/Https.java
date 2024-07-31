package demo.HttpsUtils;

import demo.Service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
@Component
@RestController(value = "/http")
public class Https {
    public static final Logger LOGGER = LoggerFactory.getLogger(Https.class);

    TokenService tokenService;

    private static final RestTemplate restTemplate = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000 * 60))//设置连接超时1分钟
            .setReadTimeout(Duration.ofMillis(1000 * 60))//设置读取数据超时1分钟
            .build();
    @Autowired
    public Https(TokenService tokenService){
        this.tokenService = tokenService;
    }
    /**
     *
     * @param url
     * @param body
     * @return
     */
    @RequestMapping(value = "/post")
    public String Post(String url, String body){
        LOGGER.info(body);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization","Bearer "+tokenService.getToken());
        httpHeaders.set("Content-Type","application/json; charset=UTF-8");
        HttpEntity<String> requestEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        LOGGER.info(responseEntity.getBody());

        return responseEntity.getBody();
    }

    /**
     *
     * @param body
     * @param builder
     * @return
     */
    @RequestMapping(value = "/get")
    public String Get(String body, UriComponentsBuilder builder){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization","Bearer "+tokenService.getToken());
        HttpEntity<String> requestEntity = new HttpEntity<>(body, httpHeaders);
        String url = builder.toUriString();
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
