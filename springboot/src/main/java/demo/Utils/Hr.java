package demo.Utils;

import demo.Service.TokenService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.net.URI;
import java.time.Duration;
@Component
@RestController
@RequestMapping(value = "/create")
public class Hr {
    public static final Logger LOGGER = LoggerFactory.getLogger(Hr.class);



    private static final RestTemplate restTemplate = new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000 * 60))//设置连接超时1分钟
            .setReadTimeout(Duration.ofMillis(1000 * 60))//设置读取数据超时1分钟
            .build();

    /**
     *
     * @param body 请求体
     * @return 返回响应结果
     */
    @RequestMapping(value = "/hr",method = RequestMethod.POST,consumes = "application/json; charset=UTF-8")
    public String Post(String body){
        LOGGER.info(body);
        String url = "http://192.168.135.5:88/isvraction/AWeb_DataExec";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(body, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        LOGGER.info("请求结果记录：   "+responseEntity.getBody());

        return responseEntity.getBody();
    }

    /**
     * 汇联易get方法
     * @param body 请求体
     * @param builder 请求头信息、url等
     * @return 返回的响应数据
     */
    @RequestMapping(value = "/get")
    public String Get(String body, UriComponentsBuilder builder){

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(body, httpHeaders);
        String url = builder.toUriString();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        LOGGER.info(responseEntity.getStatusCode().toString());

        LOGGER.info(responseEntity.getBody());

        return responseEntity.getBody();
    }


}
