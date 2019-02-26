package top.nikochen.officialwebsite.face;

import com.alibaba.fastjson.JSONObject;
import top.nikochen.officialwebsite.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 人脸检测与属性分析
 */
public class FaceDetect {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String detect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            String imageUrl = "http://img1.3lian.com/2015/a1/46/d/100.jpg";//"027d8308a2ec665acb1bdf63e513bcb9"
            map.put("image", imageUrl);
            map.put("face_field", "faceshape,facetype");
            map.put("image_type", "URL");

//            MultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<String, String>();
//            String imageUrl ="027d8308a2ec665acb1bdf63e513bcb9";
//            linkedMultiValueMap.add("image", imageUrl);
//            linkedMultiValueMap.add("face_field", "faceshape,facetype");
//            linkedMultiValueMap.add("image_type", "FACE_TOKEN");

            String param = JSONObject.toJSONString(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();


            // String result = HttpClient.client(url, HttpMethod.POST,linkedMultiValueMap);

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}