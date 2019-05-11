package me.xiaoyuu.course_helper.service;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.core.service.Service;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface GradeService extends Service<Grade> {
    int saveWithIgnore(Grade grade);
}
