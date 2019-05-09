package me.xiaoyuu.course_helper.dto;

public class RawCourseInfoDTO {
    String jx02id;

    //获取选课阶段方法的返回值
    String jx0502id;

    //课程属性名
    String kcsxm;

    //教师姓名
    String jsxm;

    //课程
    String kcxzm;

    //性别要求
    String xbyq;

    String jx0504id;

    //选课人数
    int xkrs;

    //课程号
    String kch;

    //限选人数
    String xxrs;

    //开课周次
    String kkzc;
    //开课时间明细
    String kksjmx;
    //教室名称
    String jsmc;
    //学分
    double xf;
    //
    String jx0404id;
    //
    String ejxkbz;
    //总学时
    int zxs;
    //课程性质名称
    String kcxzmc;
    //课程时间
    String kcsj;
    //授课教师
    String skjs;
    //单位名称
    String dwmc;
    String xb;
    int syrs;
    //开课周次明细
    private String kkzcmx;
    //选课班级
    private String xkbj;
    private String szkcfl;
    //课程名称
    private String kcmc;

    private String kcsx;
    private String fzm;

    public String getJx02id() {
        return jx02id;
    }

    public void setJx02id(String jx02id) {
        this.jx02id = jx02id;
    }

    public String getJx0502id() {
        return jx0502id;
    }

    public void setJx0502id(String jx0502id) {
        this.jx0502id = jx0502id;
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

    public String getXbyq() {
        return xbyq;
    }

    public void setXbyq(String xbyq) {
        this.xbyq = xbyq;
    }

    public String getJx0504id() {
        return jx0504id;
    }

    public void setJx0504id(String jx0504id) {
        this.jx0504id = jx0504id;
    }

    public int getXkrs() {
        return xkrs;
    }

    public void setXkrs(int xkrs) {
        this.xkrs = xkrs;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    public String getXxrs() {
        return xxrs;
    }

    public void setXxrs(String xxrs) {
        this.xxrs = xxrs;
    }

    public String getKkzc() {
        return kkzc;
    }

    public void setKkzc(String kkzc) {
        this.kkzc = kkzc;
    }

    public String getKkzcmx() {
        return kkzcmx;
    }

    public void setKkzcmx(String kkzcmx) {
        this.kkzcmx = kkzcmx;
    }

    public String getKksjmx() {
        return kksjmx;
    }

    public void setKksjmx(String kksjmx) {
        this.kksjmx = kksjmx;
    }

    public String getJsmc() {
        return jsmc;
    }

    public void setJsmc(String jsmc) {
        this.jsmc = jsmc;
    }

    public double getXf() {
        return xf;
    }

    public void setXf(double xf) {
        this.xf = xf;
    }

    public String getJx0404id() {
        return jx0404id;
    }

    public void setJx0404id(String jx0404id) {
        this.jx0404id = jx0404id;
    }

    public String getEjxkbz() {
        return ejxkbz;
    }

    public void setEjxkbz(String ejxkbz) {
        this.ejxkbz = ejxkbz;
    }

    public int getZxs() {
        return zxs;
    }

    public void setZxs(int zxs) {
        this.zxs = zxs;
    }

    public String getKcxzmc() {
        return kcxzmc;
    }

    public void setKcxzmc(String kcxzmc) {
        this.kcxzmc = kcxzmc;
    }

    public String getKcsj() {
        return kcsj;
    }

    public void setKcsj(String kcsj) {
        this.kcsj = kcsj;
    }

    public String getSkjs() {
        return skjs;
    }

    public void setSkjs(String skjs) {
        this.skjs = skjs;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public int getSyrs() {
        return syrs;
    }

    public void setSyrs(int syrs) {
        this.syrs = syrs;
    }

    public String getXkbj() {
        return xkbj;
    }

    public void setXkbj(String xkbj) {
        this.xkbj = xkbj;
    }

    public String getSzkcfl() {
        return szkcfl;
    }

    public void setSzkcfl(String szkcfl) {
        this.szkcfl = szkcfl;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getKcsx() {
        return kcsx;
    }

    public void setKcsx(String kcsx) {
        this.kcsx = kcsx;
    }

    public String getFzm() {
        return fzm;
    }

    public void setFzm(String fzm) {
        this.fzm = fzm;
    }

    @Override
    public String toString() {
        return "RawCourseInfo{" +
                "jx02id='" + jx02id + '\'' +
                ", jx0502id='" + jx0502id + '\'' +
                ", kcsxm='" + kcsxm + '\'' +
                ", jsxm='" + jsxm + '\'' +
                ", kcxzm='" + kcxzm + '\'' +
                ", xbyq='" + xbyq + '\'' +
                ", jx0504id='" + jx0504id + '\'' +
                ", xkrs=" + xkrs +
                ", kch='" + kch + '\'' +
                ", xxrs='" + xxrs + '\'' +
                ", kkzc='" + kkzc + '\'' +
                ", kkzcmx='" + kkzcmx + '\'' +
                ", kksjmx='" + kksjmx + '\'' +
                ", jsmc='" + jsmc + '\'' +
                ", xf=" + xf +
                ", jx0404id='" + jx0404id + '\'' +
                ", ejxkbz='" + ejxkbz + '\'' +
                ", zxs=" + zxs +
                ", kcxzmc='" + kcxzmc + '\'' +
                ", kcsj='" + kcsj + '\'' +
                ", skjs='" + skjs + '\'' +
                ", dwmc='" + dwmc + '\'' +
                ", xb='" + xb + '\'' +
                ", syrs=" + syrs +
                ", xkbj='" + xkbj + '\'' +
                ", szkcfl='" + szkcfl + '\'' +
                ", kcmc='" + kcmc + '\'' +
                ", kcsx='" + kcsx + '\'' +
                ", fzm='" + fzm + '\'' +
                '}';
    }
}
