package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface CourseService extends Service<Course> {

    int saveWithIgnore(Course course);

    List<Course> findCourseListByKeyword(String keyword);
}
