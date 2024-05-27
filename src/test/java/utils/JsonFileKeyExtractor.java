package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * 获取或修改json文件中key和value
 */

public class JsonFileKeyExtractor {
    private static final Logger log = LogManager.getLogger(JsonFileKeyExtractor.class);

    /*
        提取json文件相关key的value
         */
    public static String getValueFromJsonFile(String filePath, String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (jsonNode.has(key)) {
            log.info("key=" + jsonNode.get(key).asText());
            return jsonNode.get(key).asText();
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in the JSON file.");
        }
    }
}

class Test {
    public static void main(String[] args) {
        String filePath = "src/test/resources/changeGlobal/changeGlobal1.json";
        String key = "key";
        String value = JsonFileKeyExtractor.getValueFromJsonFile(filePath, key);
        System.out.println(value);
    }
}
