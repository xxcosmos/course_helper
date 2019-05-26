package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.core.service.Service;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface UserService extends Service<User> {
    Result bind(String openid, Student student);

    Integer getUserIdByOpenId(String openId);
}
