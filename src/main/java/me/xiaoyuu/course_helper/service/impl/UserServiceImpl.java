package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.dao.UserMapper;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.StudentService;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userInfoMapper;
    @Resource
    private StudentService studentService;


    public Result bind(String openid, Student student) {
        if (StringUtils.isBlank(student.getStudentId()) || StringUtils.isBlank(student.getStudentName())) {
            return ResultGenerator.genFailResult("缺少参数");
        }

        Student student1 = studentService.findBy("studentId", student.getStudentId());
        if (student1 == null || !student.getStudentName().equals(student1.getStudentName())) {
            return ResultGenerator.genFailResult("认证失败");
        }

        if (userInfoMapper.isStudentIdBound(student.getStudentId()) > 0) {
            return ResultGenerator.genFailResult("已被绑定");
        }

        User user = this.findBy("openid", openid);
        user.setUpdateTime(null);
        user.setStudentId(student.getStudentId());
        user.setState(1);
        this.update(user);

        return ResultGenerator.genSuccessResult();
    }

    public Integer getUserIdByOpenId(String openId) {
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        User user = findBy("openid", openId);
        if (user == null) {
            return null;
        }

        return user.getId();
    }

}
