package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.CourseTeacher;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface CourseTeacherService extends Service<CourseTeacher> {
    List<CourseTeacher> findListByCourseId(String courseCode);

}
