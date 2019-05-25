package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface StudentService extends Service<Student> {
    List<Student> findByGrade(String grade);

    int saveIgnore(Student student);
}
