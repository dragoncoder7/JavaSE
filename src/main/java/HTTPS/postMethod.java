package HTTPS;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class postMethod {
    private static final String stage = "https://apistage.huilianyi.com/gateway";
    private static final String APP_KEY = "897352c6-78af-4e62-abf5-597800cce181";
    private static final String APP_SECURET = "ODQ1MWJhMjctYmMyZC00MWI5LThhYWQtZmM4YjgwNzljYWQ2";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(60 * 1000)
                .setSocketTimeout(60 * 1000)
                .build();
        HttpPost httpPost = new HttpPost(stage+"/oauth/token");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String json = "grant_type=client_credentials&scope=write";
            httpPost.setEntity(new StringEntity(json));
        httpPost.setHeader("Authorization","Basic "+ Base64.encodeBase64String(APP_KEY.concat(":").concat(APP_SECURET).getBytes()));
        System.out.println(httpPost.getMethod());
        httpPost.setConfig(requestConfig);
        HttpResponse httpResponse = httpclient.execute(httpPost);
        String responseBody = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(httpResponse.getStatusLine());
        System.out.println(responseBody);

    }
}
