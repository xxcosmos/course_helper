package me.xiaoyuu.course_helper.vo;

import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Course;

import java.util.List;

public class CourseVO {
    private Course course;
    private List<TeacherInfoDTO> teacherList;

    private List<CommentVO> commentVOList;

    public CourseVO(Course course, List<TeacherInfoDTO> teacherList, List<CommentVO> commentVOList) {
        this.course = course;
        this.teacherList = teacherList;
        this.commentVOList = commentVOList;
    }

    public List<CommentVO> getCommentVOList() {
        return commentVOList;
    }

    public void setCommentVOList(List<CommentVO> commentVOList) {
        this.commentVOList = commentVOList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<TeacherInfoDTO> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherInfoDTO> teacherList) {
        this.teacherList = teacherList;
    }
}
