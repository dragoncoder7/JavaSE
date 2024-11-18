package demo.Utils;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
@Configuration
public class ApiConfig {
    @Bean(value = "RestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(1000 * 60))//设置连接超时1分钟
                .setReadTimeout(Duration.ofMillis(1000 * 60))//设置读取数据超时1分钟
                .build();
    }
}
