package me.xiaoyuu.course_helper.vo;

import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Course;

import java.util.List;

public class CourseVO {
    private Course course;
    private int averageRate;
    private List<TeacherInfoDTO> teacherList;
    private List<CommentVO> commentVOList;
    private int commentNum;
    private int fileNum;
    private boolean isCollected;
    private int collectionNum;

    @Override
    public String toString() {
        return "CourseVO{" +
                "course=" + course +
                ", averageRate=" + averageRate +
                ", teacherList=" + teacherList +
                ", commentVOList=" + commentVOList +
                ", commentNum=" + commentNum +
                ", fileNum=" + fileNum +
                ", isCollected=" + isCollected +
                ", collectionNum=" + collectionNum +
                '}';
    }

    public CourseVO(Course course, int averageRate, int commentNum, int fileNum, int collectionNum) {
        this.course = course;
        this.averageRate = averageRate;
        this.commentNum = commentNum;
        this.fileNum = fileNum;
        this.collectionNum = collectionNum;
    }

    public CourseVO(Course course, int averageRate, List<TeacherInfoDTO> teacherList, List<CommentVO> commentVOList, int fileNum, boolean isCollected, int collectionNum) {
        this.course = course;
        this.averageRate = averageRate;
        this.teacherList = teacherList;
        this.commentVOList = commentVOList;
        this.fileNum = fileNum;
        this.isCollected = isCollected;
        this.collectionNum = collectionNum;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public int getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(int averageStar) {
        this.averageRate = averageStar;
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

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
    }
}
