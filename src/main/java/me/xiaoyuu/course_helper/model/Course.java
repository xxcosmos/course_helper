package me.xiaoyuu.course_helper.model;

import javax.persistence.*;

public class Course {
    /**
     * 课程代码
     */
    @Id
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
     * 开课单位名称
     */
    @Column(name = "unit_name")
    private String unitName;

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

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCredit='" + courseCredit + '\'' +
                ", courseHour=" + courseHour +
                ", courseType=" + courseType +
                ", courseTypeName='" + courseTypeName + '\'' +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}