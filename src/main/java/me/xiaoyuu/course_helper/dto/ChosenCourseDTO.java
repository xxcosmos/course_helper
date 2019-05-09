package me.xiaoyuu.course_helper.dto;

public class ChosenCourseDTO {
    private String dwmc;
    private String kcxzmc;
    private String kcsxm;
    private String jsxm;
    private String kcxzm;
    private String szkcfl;
    private String kch;
    private int zxs;
    private String kcsx;
    private String kcmc;
    private double xf;

    @Override
    public String toString() {
        return "ChosenCourseDTO{" +
                "dwmc='" + dwmc + '\'' +
                ", kcxzmc='" + kcxzmc + '\'' +
                ", kcsxm='" + kcsxm + '\'' +
                ", jsxm='" + jsxm + '\'' +
                ", kcxzm='" + kcxzm + '\'' +
                ", szkcfl='" + szkcfl + '\'' +
                ", kch='" + kch + '\'' +
                ", zxs=" + zxs +
                ", kcsx='" + kcsx + '\'' +
                ", kcmc='" + kcmc + '\'' +
                ", xf=" + xf +
                '}';
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getKcxzmc() {
        return kcxzmc;
    }

    public void setKcxzmc(String kcxzmc) {
        this.kcxzmc = kcxzmc;
    }

    public String getKcsxm() {
        return kcsxm;
    }

    public void setKcsxm(String kcsxm) {
        this.kcsxm = kcsxm;
    }

    public String getJsxm() {
        return jsxm;
    }

    public void setJsxm(String jsxm) {
        this.jsxm = jsxm;
    }

    public String getKcxzm() {
        return kcxzm;
    }

    public void setKcxzm(String kcxzm) {
        this.kcxzm = kcxzm;
    }

    public String getSzkcfl() {
        return szkcfl;
    }

    public void setSzkcfl(String szkcfl) {
        this.szkcfl = szkcfl;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    public int getZxs() {
        return zxs;
    }

    public void setZxs(int zxs) {
        this.zxs = zxs;
    }

    public String getKcsx() {
        return kcsx;
    }

    public void setKcsx(String kcsx) {
        this.kcsx = kcsx;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public double getXf() {
        return xf;
    }

    public void setXf(double xf) {
        this.xf = xf;
    }
}