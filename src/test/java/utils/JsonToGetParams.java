package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 主要是将json文件的内容转换为get请求的参数
 *
 */
public class JsonToGetParams {

    public static String jsonFileToGetParams(String filePath) {
        try {
            // 创建 ObjectMapper 实例
            ObjectMapper objectMapper = new ObjectMapper();
            // 读取 JSON 文件并转换为 Map<String, Object>
            File jsonFile = new File(filePath);
            Map<String, Object> jsonMap = objectMapper.readValue(jsonFile, Map.class);

            StringBuilder paramsBuilder = new StringBuilder();
            boolean isFirstParam = true;

            // 遍历Map，构造查询参数字符串
            for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
                if (!isFirstParam) {
                    paramsBuilder.append("&");
                }
                paramsBuilder.append(entry.getKey()).append("=").append(entry.getValue().toString());
                isFirstParam = false;
            }

            return paramsBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading or parsing JSON file", e);
        }
    }
}