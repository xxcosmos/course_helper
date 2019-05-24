package me.xiaoyuu.course_helper.util;

import com.alibaba.fastjson.JSON;
import com.tencent.cloud.CosStsClient;
import me.xiaoyuu.course_helper.constant.Constant;
import me.xiaoyuu.course_helper.dto.CosCredential;
import org.json.JSONObject;

import java.io.IOException;
import java.util.TreeMap;

public class CosUtil {


    public static CosCredential getTempCredential() {

        JSONObject credential = null;
        try {
            credential = CosStsClient.getCredential(getConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert credential != null;
        return JSON.parseObject(credential.toString(4), CosCredential.class);
    }

    public static TreeMap<String, Object> getConfig() {
        TreeMap<String, Object> config = new TreeMap<>();
        config.put("SecretId", Constant.COS.SECRET_ID);
        config.put("SecretKey", Constant.COS.SECRET_KEY);
        config.put("durationSeconds", Constant.COS.DURATION_SECONDS);
        config.put("bucket", Constant.COS.BUCKET);
        config.put("region", Constant.COS.REGION);
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
