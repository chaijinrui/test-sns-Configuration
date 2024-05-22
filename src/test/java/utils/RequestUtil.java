package utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RequestUtil {
    public static String getRequest(String url, String token) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建HttpGet请求
            HttpGet httpGet = new HttpGet(url);
            long startTime = System.nanoTime();

            // 设置cookie
            httpGet.setHeader("Cookie", token);
            String responseBody = "1";
            // 执行请求
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                // 获取响应状态码
                int statusCode = response.getStatusLine().getStatusCode();

                // 检查响应状态码是否为200
                if (statusCode == 200) {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();

                    // 将实体转换为字符串
                    responseBody = EntityUtils.toString(entity);

                    // 输出响应内容
//                    System.out.println("Response Body: " + responseBody);


                    // 这里可以根据需要添加更详细的断言来验证响应内容
                    // 例如，使用JSON解析库来验证返回的JSON数据
                } else {
                    System.out.println("Request failed with status code: " + statusCode);
                }
            }
            return responseBody;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

