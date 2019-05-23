package me.xiaoyuu.course_helper.dto;

public class Credentials {

    private String tmpSecretId;
    private String tmpSecretKey;
    private String sessionToken;

    @Override
    public String toString() {
        return "Credentials{" +
                "tmpSecretId='" + tmpSecretId + '\'' +
                ", tmpSecretKey='" + tmpSecretKey + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                '}';
    }

    public String getTmpSecretId() {
        return tmpSecretId;
    }

    public void setTmpSecretId(String tmpSecretId) {
        this.tmpSecretId = tmpSecretId;
    }

    public String getTmpSecretKey() {
        return tmpSecretKey;
    }

    public void setTmpSecretKey(String tmpSecretKey) {
        this.tmpSecretKey = tmpSecretKey;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
