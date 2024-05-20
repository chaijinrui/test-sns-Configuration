package services;

import utils.JsonToGetParams;
import utils.JsonToPostParams;

/**
 * 3个关于应用维度全局配置功能
 * 1. 新增全局配置
 * 2. 修改全局配置
 * 3. 删除全局配置
 */

public class GlobalDimensionConfiguration {
    // 1. 新增
    //http://cms.cyngame.cn:8190/initAction/initLoadTable.action?
// actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue={"asId":"9483,5717,3018","key":"MLS","value":"1","cId":0}
    private String addGlobalDimensionConfigurationUrl = "http://cms.cyngame.cn:8190/initAction/initLoadTable.action?" +
            "actions=addAdvertCommonConfigValues&methodName=AdvertJoinSDK_ReCreate&formValue=";

    public String addGlobalDimensionConfiguration(String token, String jsonFilePath) {
        addGlobalDimensionConfigurationUrl = addGlobalDimensionConfigurationUrl + "{" + JsonToPostParams.jsonFileToPostParams("src/main/resources/addGlobal.json") + "}";

        return addGlobalDimensionConfigurationUrl;
    }


//    测试代码
    public static void main(String[] args) {
        System.out.println(new GlobalDimensionConfiguration().addGlobalDimensionConfiguration("7059DEB20FA927661A5FEA9AE7095396.jvm1", "src/main/resources/addGlobal.json"));
    }
}
