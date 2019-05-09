package me.xiaoyuu.course_helper.model;

import javax.persistence.*;

@Table(name = "raw_course_info")
public class RawCourseInfo {
    @Id
    @Column(name = "course_code")
    private String courseCode;

    @Id
    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "course_type_name")
    private String courseTypeName;

    @Column(name = "course_type")
    private String courseType;

    @Column(name = "course_type_code")
    private String courseTypeCode;

    private String szkcfl;

    @Column(name = "course_hour")
    private Integer courseHour;

    private String kcsx;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_credit")
    private String courseCredit;

    /**
     * @return course_code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return teacher_name
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return unit_name
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * @param unitName
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * @return course_type_name
     */
    public String getCourseTypeName() {
        return courseTypeName;
    }

    /**
     * @param courseTypeName
     */
    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    /**
     * @return course_type
     */
    public String getCourseType() {
        return courseType;
    }

    /**
     * @param courseType
     */
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    /**
     * @return course_type_code
     */
    public String getCourseTypeCode() {
        return courseTypeCode;
    }

    /**
     * @param courseTypeCode
     */
    public void setCourseTypeCode(String courseTypeCode) {
        this.courseTypeCode = courseTypeCode;
    }

    /**
     * @return szkcfl
     */
    public String getSzkcfl() {
        return szkcfl;
    }

    /**
     * @param szkcfl
     */
    public void setSzkcfl(String szkcfl) {
        this.szkcfl = szkcfl;
    }

    /**
     * @return course_hour
     */
    public Integer getCourseHour() {
        return courseHour;
    }

    /**
     * @param courseHour
     */
    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    /**
     * @return kcsx
     */
    public String getKcsx() {
        return kcsx;
    }

    /**
     * @param kcsx
     */
    public void setKcsx(String kcsx) {
        this.kcsx = kcsx;
    }

    /**
     * @return course_name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return course_credit
     */
    public String getCourseCredit() {
        return courseCredit;
    }

    /**
     * @param courseCredit
     */
    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }
}