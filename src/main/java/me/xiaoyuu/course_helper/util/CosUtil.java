package me.xiaoyuu.course_helper.util;

import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import me.xiaoyuu.course_helper.constant.CosConstant;

import java.util.Date;

public class CosUtil {
    public static String GetAPostUploadSign(String key) {
        COSCredentials credentials = new BasicCOSCredentials(CosConstant.SECRET_ID, CosConstant.SECRET_KEY);
        Date expiredTime = new Date(System.currentTimeMillis() + 300L * 1000L);
        return new COSSigner().buildAuthorizationStr(HttpMethodName.POST, key, credentials, expiredTime);
    }
}
