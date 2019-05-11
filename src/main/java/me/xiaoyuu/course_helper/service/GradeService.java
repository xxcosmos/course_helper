package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface GradeService extends Service<Grade> {
    int saveWithIgnore(Grade grade);

    List<TeacherInfoDTO> selectTeacherByCourseCode(String courseCode);

}
