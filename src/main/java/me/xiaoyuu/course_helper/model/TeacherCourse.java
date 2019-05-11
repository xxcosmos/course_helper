package me.xiaoyuu.course_helper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "teacher_course")
public class TeacherCourse {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "course_id")
    private Integer courseId;

    /**
     * 总选课人数
     */
    private Integer count;

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
     * @return course_id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取总选课人数
     *
     * @return count - 总选课人数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置总选课人数
     *
     * @param count 总选课人数
     */
    public void setCount(Integer count) {
        this.count = count;
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