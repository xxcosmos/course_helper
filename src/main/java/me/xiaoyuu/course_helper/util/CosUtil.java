package me.xiaoyuu.course_helper.util;

import com.alibaba.fastjson.JSON;
import com.tencent.cloud.CosStsClient;
import me.xiaoyuu.course_helper.dto.CosCredential;
import org.json.JSONObject;

import java.io.IOException;
import java.util.TreeMap;

public class CosUtil {
    private static final String secretId = "AKIDQoBPSiQueDe0I0LCavAJKjy11rdNGiFb";
    private static final String secretKey = "A808g3WyQCyhGhxDQjsENdeg4KPOCssi";

    public static CosCredential getTempCredential() {

        JSONObject credential = null;
        try {
            credential = CosStsClient.getCredential(getConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }
        CosCredential cosCredential = JSON.parseObject(credential.toString(4), CosCredential.class);
        return cosCredential;
    }

    public static TreeMap<String, Object> getConfig() {
        TreeMap<String, Object> config = new TreeMap<>();
        config.put("SecretId", secretId);
        config.put("SecretKey", secretKey);
        config.put("durationSeconds", 1800);
        config.put("bucket", "inwust-1251756217");
        // 换成 bucket 所在地区
        config.put("region", "ap-chengdu");
        config.put("allowPrefix", "*");
        String[] allowActions = new String[]{
                // 简单上传
                "name/cos:PutObject",
                // 表单上传、小程序上传
                "name/cos:PostObject"
        };
        config.put("allowActions", allowActions);
        return config;
    }
}
