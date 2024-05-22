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
    //  新增配置接口
    private String addGlobalDimensionConfigurationUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
            "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=";

    // 1. 新增
    public String addGlobalDimensionConfiguration(String token, String jsonFilePath) {
        try {
//            编码后的url
            addGlobalDimensionConfigurationUrl = addGlobalDimensionConfigurationUrl + URLEncoder.encode("{" + JsonToPostParams.jsonFileToPostParams("src/test/resources/addGlobal.json") + "}", "UTF-8");
            log.info("配置:" + JsonToPostParams.jsonFileToPostParams("src/test/resources/addGlobal.json"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
//调用请求类
        return RequestUtil.getRequest(addGlobalDimensionConfigurationUrl, token);
    }


    //    测试代码
    public static void main(String[] args) throws IOException {
        log.info("responseBody:" +
                new GlobalDimensionConfiguration().addGlobalDimensionConfiguration(GetToken.getToken(), "src/main/resources/addGlobal.json"));
    }
}
