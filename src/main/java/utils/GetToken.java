package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * 从登录接口获取token，用于其他方法的使用
 */

public class GetToken {
    private static final String urlStr = "http://cms.cyngame.cn:8190/login/login.action?UserName=sns_cjr&PassWord=123456";
    public static String token;


    public static String getToken() throws IOException {
        // 创建URL对象
        URL url = new URL(urlStr);

        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 设置请求方法，默认是GET
        connection.setRequestMethod("GET");

        // 发送请求
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        // 获取所有响应头
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (Objects.equals(entry.getKey(), "Set-Cookie")) {
                token = entry.getValue().get(0); // 获取第一个值
                break;
            }
        }

        // 关闭连接
        connection.disconnect();

//        从header中拿到JSESSIONID
        token = token.substring(token.indexOf("=") + 1, token.indexOf(";"));
        return token;
    }
}



