package demo.HttpsUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
@RestController(value = "/http")
public class Https {
    public static final Logger LOGGER = LoggerFactory.getLogger(Https.class);

    private static final RestTemplate restTemplate = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000 * 60))//设置连接超时1分钟
            .setReadTimeout(Duration.ofMillis(1000 * 60))//设置读取数据超时1分钟
            .build();

    /**
     *
     * @param url
     * @param body
     * @param httpHeaders
     * @return
     */
    @RequestMapping(value = "/post")
    public static String Post(String url, String body, HttpHeaders httpHeaders){


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
     * @param httpHeaders
     * @param builder
     * @return
     */
    @RequestMapping(value = "/get")
    public static String Get(String body, HttpHeaders httpHeaders, UriComponentsBuilder builder){


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
