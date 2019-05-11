package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.CourseTeacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseTeacherMapper extends Mapper<CourseTeacher> {

    List<CourseTeacher> getListByCourseCode(@Param("courseCode") String courseCode);

}