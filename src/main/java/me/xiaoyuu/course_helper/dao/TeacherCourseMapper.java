package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.TeacherCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherCourseMapper extends Mapper<TeacherCourse> {

    List<TeacherCourse> getListByCourseId(@Param("courseId") int courseId);
}