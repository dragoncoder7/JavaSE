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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.net.URI;
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
     * 汇联易post方法
     * @param url 访问地址
     * @param body 请求体
     * @return 访问响应结果
     */
    @RequestMapping(value = "/post")
    public String Post(String url, String body){
        LOGGER.info(body);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization","Bearer "+tokenService.getToken());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
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
     * 汇联易get方法
     * @param body 请求体
     * @param builder 请求头信息、url等
     * @return 返回的响应数据
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

        LOGGER.info(responseEntity.getStatusCode().toString());

        LOGGER.info(responseEntity.getBody());

        return responseEntity.getBody();
    }

    /**
     * 创建汇联易单据
     * @param requestId OA流程id
     * @return 该方法已废弃 通过JSON请求体获得requestId 而不是参数传递
     */
    @RequestMapping(value = "/postToHelios",method = RequestMethod.POST,consumes = "application/json; charset=UTF-8")
    public String Post1(@Param("requestId") Integer requestId){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/travelApplication/create")
                .queryParam("requestId", requestId)
                .build()
                .toUri();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                requestEntity,
                String.class);

        LOGGER.info(responseEntity.getBody());

        return responseEntity.getBody();
    }

    @RequestMapping(value = "/attachment")
    public String PostAttachment(String url ,File file){

        // 配置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization","Bearer "+tokenService.getToken());
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 创建 MultiValueMap 用于保存文件和其他字段
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(file));
        //body.add("description", "This is a test file"); // 如果需要添加其他表单字段

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);

        // 执行 POST 请求
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        LOGGER.info(response.getBody());

        return response.getBody();

    }
}
