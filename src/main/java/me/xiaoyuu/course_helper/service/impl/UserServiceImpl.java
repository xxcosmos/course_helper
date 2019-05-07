package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.UserMapper;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/07.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Value("${wx.applet.app-id}")
    private String appid;
    @Value("${wx.applet.app-secret}")
    private String appSecret;
    @Resource
    private UserMapper courseHelperUserMapper;

}
