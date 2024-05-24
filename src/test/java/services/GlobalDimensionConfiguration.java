package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.GetToken;
import utils.JsonToPostParams;
import utils.RequestUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 3个关于应用维度全局配置功能
 * 1. 新增全局配置
 * 2. 修改全局配置
 * 3. 删除全局配置
 */

public class GlobalDimensionConfiguration {

    private static final Logger log = LogManager.getLogger(GlobalDimensionConfiguration.class);
    //  新增、修改配置接口
    private String addGlobalDimensionConfigurationUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
            "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=";


    // 1. 新增

    /**
     * @param token
     * @param jsonFilePath "asId": "9483,5717,3018",     渠道ID、应用ID、skdid（目前是3018）
     *                     "key": "M5LS",              开关ID
     *                     "value": "1",               值
     *                     "cId": 0                    这条配置的唯一标识
     * @return
     */
    public String addGlobalDimensionConfiguration(String token, String jsonFilePath) {
        try {
//            编码后的url
            addGlobalDimensionConfigurationUrl = addGlobalDimensionConfigurationUrl + URLEncoder.encode("{" + JsonToPostParams.jsonFileToPostParams("src/test/resources/addGlobal1.json") + "}", "UTF-8");
            log.info("配置:" + JsonToPostParams.jsonFileToPostParams("src/test/resources/addGlobal1.json"));
//            log.info(addGlobalDimensionConfigurationUrl);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
//调用请求方法
        return RequestUtil.getRequest(addGlobalDimensionConfigurationUrl, token);
    }


    // 2. 修改

    /**
     * @param token
     * @param jsonFilePath 同新增接口参数
     * @return
     */
    //TODO
    public String changeGlobalDimensionConfiguration(String token, String jsonFilePath) {

    }


    //    测试代码
    public static void main(String[] args) throws IOException {
        log.info("responseBody:" +
                new GlobalDimensionConfiguration().addGlobalDimensionConfiguration(GetToken.getToken(), "src/main/resources/addGlobal1.json"));
    }
}
