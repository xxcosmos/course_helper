package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.RawCourseInfo;
import me.xiaoyuu.course_helper.core.service.Service;


/**
 * Created by xiaoyuu on 2019/05/08.
 */
public interface RawCourseInfoService extends Service<RawCourseInfo> {
    int savetWithIgnore(RawCourseInfo rawCourseInfo);
}
