package me.xiaoyuu.course_helper.model;

import javax.persistence.*;

public class Student {
    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "student_name")
    private String studentName;

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
     * @return student_name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}