package me.xiaoyuu.course_helper.dto;

public class CosCredential {

    private Credentials credentials;
    private String requeseId;
    private String expiration;
    private String startTime;
    private String expiredTime;

    @Override
    public String toString() {
        return "CosCredential{" +
                "credentials=" + credentials +
                ", requeseId='" + requeseId + '\'' +
                ", expiration='" + expiration + '\'' +
                ", startTime='" + startTime + '\'' +
                ", expiredTime='" + expiredTime + '\'' +
                '}';
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getRequeseId() {
        return requeseId;
    }

    public void setRequeseId(String requeseId) {
        this.requeseId = requeseId;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }
}
