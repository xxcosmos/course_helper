package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.StudentInfo;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/08.
 */
public interface StudentInfoService extends Service<StudentInfo> {
    List<StudentInfo> findByGrade(String grade);
}
