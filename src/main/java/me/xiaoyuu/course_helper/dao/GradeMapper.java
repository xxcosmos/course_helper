package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper extends Mapper<Grade> {

    int insertWithIgnore(@Param("grade") Grade grade);

    List<TeacherInfoDTO> selectTeacherInfoByCourseCode(@Param("courseCode") String courseCode);
}