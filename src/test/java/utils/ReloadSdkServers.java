package utils;


/*
立即生效功能
 */
public class ReloadSdkServers {
    public static void ReloadSDKServers(String token){
        String baseurl="http://cms.cyngame.cn:8190/initAction/initLoadTable.action";
        RequestUtil.getRequest(baseurl,token);
    }
}
