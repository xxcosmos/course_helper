package me.xiaoyuu.course_helper.controller;

import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;
import me.xiaoyuu.course_helper.config.jwt.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/07.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    JwtConfig jwtConfig;

    @GetMapping("/login")
    public Result login(String code) {
        User user = new User();
        user.setOpenid("xxx");
        user.setSessionKey("sdfsdf");
        String token = jwtConfig.getToken(user);
        return ResultGenerator.genSuccessResult(token);
    }

    @RequiresAuthentication
    @GetMapping("/hello")
    public Result sayHello() {
        return ResultGenerator.genSuccessResult("hello");
    }
}
