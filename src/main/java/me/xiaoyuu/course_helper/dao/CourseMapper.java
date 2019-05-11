package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper extends Mapper<Course> {

    int insertWithIgnore(@Param("course") Course course);

    List<Course> selectListByKeyword(@Param("keyword") String keyword);
}