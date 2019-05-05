package me.xiaoyuu.course_helper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "course_info")
public class CourseInfo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程代码
     */
    @Column(name = "course_code")
    private String courseCode;

    /**
     * 课程名称
     */
    @Column(name = "course_name")
    private String courseName;

    /**
     * 学分
     */
    @Column(name = "course_credit")
    private String courseCredit;

    /**
     * 总学时
     */
    @Column(name = "course_hour")
    private Integer courseHour;

    /**
     * 0:未知,1:必修,2:选修
     */
    @Column(name = "course_type")
    private Integer courseType;

    /**
     * 课程性质名称
     */
    @Column(name = "course_type_name")
    private String courseTypeName;

    /**
     * 教师姓名
     */
    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * 开课单位名称
     */
    @Column(name = "unit_name")
    private String unitName;

    /**
     * 平均成绩
     */
    @Column(name = "average_grade")
    private String averageGrade;

    /**
     * 成绩样本人数
     */
    @Column(name = "grade_count")
    private Integer gradeCount;

    /**
     * 及格率
     */
    @Column(name = "pass_percent")
    private String passPercent;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取课程代码
     *
     * @return course_code - 课程代码
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * 设置课程代码
     *
     * @param courseCode 课程代码
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * 获取课程名称
     *
     * @return course_name - 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置课程名称
     *
     * @param courseName 课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取学分
     *
     * @return course_credit - 学分
     */
    public String getCourseCredit() {
        return courseCredit;
    }

    /**
     * 设置学分
     *
     * @param courseCredit 学分
     */
    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }

    /**
     * 获取总学时
     *
     * @return course_hour - 总学时
     */
    public Integer getCourseHour() {
        return courseHour;
    }

    /**
     * 设置总学时
     *
     * @param courseHour 总学时
     */
    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    /**
     * 获取0:未知,1:必修,2:选修
     *
     * @return course_type - 0:未知,1:必修,2:选修
     */
    public Integer getCourseType() {
        return courseType;
    }

    /**
     * 设置0:未知,1:必修,2:选修
     *
     * @param courseType 0:未知,1:必修,2:选修
     */
    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    /**
     * 获取课程性质名称
     *
     * @return course_type_name - 课程性质名称
     */
    public String getCourseTypeName() {
        return courseTypeName;
    }

    /**
     * 设置课程性质名称
     *
     * @param courseTypeName 课程性质名称
     */
    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    /**
     * 获取教师姓名
     *
     * @return teacher_name - 教师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置教师姓名
     *
     * @param teacherName 教师姓名
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 获取开课单位名称
     *
     * @return unit_name - 开课单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置开课单位名称
     *
     * @param unitName 开课单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取平均成绩
     *
     * @return average_grade - 平均成绩
     */
    public String getAverageGrade() {
        return averageGrade;
    }

    /**
     * 设置平均成绩
     *
     * @param averageGrade 平均成绩
     */
    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
    }

    /**
     * 获取成绩样本人数
     *
     * @return grade_count - 成绩样本人数
     */
    public Integer getGradeCount() {
        return gradeCount;
    }

    /**
     * 设置成绩样本人数
     *
     * @param gradeCount 成绩样本人数
     */
    public void setGradeCount(Integer gradeCount) {
        this.gradeCount = gradeCount;
    }

    /**
     * 获取及格率
     *
     * @return pass_percent - 及格率
     */
    public String getPassPercent() {
        return passPercent;
    }

    /**
     * 设置及格率
     *
     * @param passPercent 及格率
     */
    public void setPassPercent(String passPercent) {
        this.passPercent = passPercent;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}