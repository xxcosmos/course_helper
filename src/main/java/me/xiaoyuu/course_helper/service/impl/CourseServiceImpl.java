package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.CourseMapper;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.service.CourseService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public int saveWithIgnore(Course course) {
        return courseMapper.insertWithIgnore(course);
    }
}
