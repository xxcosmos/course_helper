package me.xiaoyuu.course_helper.model;

import javax.persistence.*;

@Table(name = "grade_info")
public class GradeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_type_name")
    private String courseTypeName;

    @Column(name = "test_type")
    private String testType;

    @Column(name = "course_type")
    private String courseType;

    private String grade;

    @Column(name = "course_hour")
    private Integer courseHour;

    @Column(name = "course_credit")
    private String courseCredit;

    private Integer jd;

    private String xq;

    private String cjbsmc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return student_id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
     * @return test_type
     */
    public String getTestType() {
        return testType;
    }

    /**
     * @param testType
     */
    public void setTestType(String testType) {
        this.testType = testType;
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
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
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

    /**
     * @return jd
     */
    public Integer getJd() {
        return jd;
    }

    /**
     * @param jd
     */
    public void setJd(Integer jd) {
        this.jd = jd;
    }

    /**
     * @return xq
     */
    public String getXq() {
        return xq;
    }

    /**
     * @param xq
     */
    public void setXq(String xq) {
        this.xq = xq;
    }

    /**
     * @return cjbsmc
     */
    public String getCjbsmc() {
        return cjbsmc;
    }

    /**
     * @param cjbsmc
     */
    public void setCjbsmc(String cjbsmc) {
        this.cjbsmc = cjbsmc;
    }
}