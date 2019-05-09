package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.RawCourseInfo;
import org.apache.ibatis.annotations.Param;

public interface RawCourseInfoMapper extends Mapper<RawCourseInfo> {
    int insertWithIgnore(@Param("RawCourseInfo") RawCourseInfo rawCourseInfo);
}