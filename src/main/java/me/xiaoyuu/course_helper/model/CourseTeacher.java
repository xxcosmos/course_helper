package me.xiaoyuu.course_helper.model;

import javax.persistence.*;

@Table(name = "course_teacher")
public class CourseTeacher {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * 总选课人数
     */
    @Column(name = "all_count")
    private Integer allCount;

    /**
     * 挂科人数
     */
    @Column(name = "no_pass_count")
    private Integer noPassCount;

    /**
     * 平均分
     */
    @Column(name = "average_grade")
    private String averageGrade;

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
     * 获取总选课人数
     *
     * @return all_count - 总选课人数
     */
    public Integer getAllCount() {
        return allCount;
    }

    /**
     * 设置总选课人数
     *
     * @param allCount 总选课人数
     */
    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    /**
     * 获取挂科人数
     *
     * @return no_pass_count - 挂科人数
     */
    public Integer getNoPassCount() {
        return noPassCount;
    }

    /**
     * 设置挂科人数
     *
     * @param noPassCount 挂科人数
     */
    public void setNoPassCount(Integer noPassCount) {
        this.noPassCount = noPassCount;
    }

    /**
     * 获取平均分
     *
     * @return average_grade - 平均分
     */
    public String getAverageGrade() {
        return averageGrade;
    }

    /**
     * 设置平均分
     *
     * @param averageGrade 平均分
     */
    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
    }
}