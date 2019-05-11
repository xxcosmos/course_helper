package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.Grade;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper extends Mapper<Grade> {

    int insertWithIgnore(@Param("grade") Grade grade);
}