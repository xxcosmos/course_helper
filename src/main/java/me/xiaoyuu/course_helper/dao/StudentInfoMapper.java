package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoMapper extends Mapper<StudentInfo> {

    List<StudentInfo> selectByGrade(@Param("grade") String grade);
}