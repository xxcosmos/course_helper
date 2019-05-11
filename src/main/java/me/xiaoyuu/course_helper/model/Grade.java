package me.xiaoyuu.course_helper.model;

import javax.persistence.*;

public class Grade {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_code")
    private String courseCode;

    private String grade;

    @Column(name = "grade_point")
    private String gradePoint;

    @Column(name = "grade_type_name")
    private String gradeTypeName;

    @Column(name = "teacher_name")
    private String teacherName;

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
     * @return grade_point
     */
    public String getGradePoint() {
        return gradePoint;
    }

    /**
     * @param gradePoint
     */
    public void setGradePoint(String gradePoint) {
        this.gradePoint = gradePoint;
    }

    /**
     * @return grade_type_name
     */
    public String getGradeTypeName() {
        return gradeTypeName;
    }

    /**
     * @param gradeTypeName
     */
    public void setGradeTypeName(String gradeTypeName) {
        this.gradeTypeName = gradeTypeName;
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
}