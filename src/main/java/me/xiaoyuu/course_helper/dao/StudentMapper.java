package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends Mapper<Student> {

    List<Student> selectByGrade(@Param("grade") String grade);

}