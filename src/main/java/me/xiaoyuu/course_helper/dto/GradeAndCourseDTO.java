package me.xiaoyuu.course_helper.dto;

import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Grade;

public class GradeAndCourseDTO {
    private Grade grade;
    private Course course;

    public GradeAndCourseDTO(Grade grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public GradeAndCourseDTO() {
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
