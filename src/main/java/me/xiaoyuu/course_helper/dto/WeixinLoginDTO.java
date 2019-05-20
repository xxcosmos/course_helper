package me.xiaoyuu.course_helper.dto;

public class WeixinLoginDTO {
    private String code;
    private UserInfo userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "WeixinLoginDTO{" +
                "code='" + code + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
