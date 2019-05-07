package me.xiaoyuu.course_helper.util;

import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import org.springframework.beans.factory.annotation.Value;


import java.util.Date;

public class CosUtil {
    @Value("${cos.secret-id}")
    private static String secretId;
    @Value("${cos.secret-key}")
    private static String secretKey;

    public static String GetAPostUploadSign(String key) {
        COSCredentials credentials = new BasicCOSCredentials(secretId, secretKey);
        Date expiredTime = new Date(System.currentTimeMillis() + 3600L * 1000L);
        return new COSSigner().buildAuthorizationStr(HttpMethodName.POST, key, credentials, expiredTime);
    }
}
