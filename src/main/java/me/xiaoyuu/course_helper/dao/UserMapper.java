package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends Mapper<User> {
    public int isStudentIdBound(@Param("studentId") String studentId);
}