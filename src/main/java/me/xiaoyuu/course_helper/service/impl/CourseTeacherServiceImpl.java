package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.CourseTeacherMapper;
import me.xiaoyuu.course_helper.model.CourseTeacher;
import me.xiaoyuu.course_helper.service.CourseTeacherService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class CourseTeacherServiceImpl extends AbstractService<CourseTeacher> implements CourseTeacherService {
    @Resource
    private CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> findListByCourseId(String courseCode) {
        return courseTeacherMapper.getListByCourseCode(courseCode);
    }
}
