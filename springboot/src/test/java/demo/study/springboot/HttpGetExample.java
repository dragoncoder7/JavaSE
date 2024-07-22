package demo.study.springboot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetExample {
    public static final Logger log = LoggerFactory.getLogger(HttpGetExample.class);
    public static void main(String[] args) {
        System.out.println("httpRequestByPOST"+httpRequestByPOST());
        for (int i = 0; i < 10; i++) {
            sendHttpRequest();
        }

    }
    public static void sendHttpRequest() {
        try {
            // 创建URL对象
            URL url = new URL("http://localhost:8080/greeting");

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置请求方法为GET
            connection.setRequestMethod("GET");

            // 获取响应码
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 读取响应内容
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // 打印响应内容
            System.out.println("Response: " + response.toString());

            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            log.info(e.getMessage());
            log.info(e.toString());
        }
    }
    public static String httpRequestByPOST() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {
            // 创建HttpGet对象
            HttpGet httpGet = new HttpGet("http://localhost:8080/greeting");

            // 执行请求

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // 获取响应实体
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    // 将响应实体转换为字符串
                    result = EntityUtils.toString(entity);
                    System.out.println("Response: " + result);
                }
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            log.info(e.toString());
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                log.info(e.getMessage());
                log.info(e.toString());
            }
        }
        return result;
    }
}

