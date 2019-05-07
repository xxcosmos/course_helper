package me.xiaoyuu.course_helper.controller;

import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserService userService;
    @Resource
    private WxMaUserService wxMaUserService;

    @GetMapping("/login")
    public Result login(String code, String encryptedData, String ivStr) {
        if (StringUtils.isBlank(code)) {
            return ResultGenerator.genFailResult("jscode needed");
        }

        try {
            WxMaJscode2SessionResult sessionInfo = wxMaUserService.getSessionInfo(code);
            WxMaUserInfo userInfo = wxMaUserService.getUserInfo(sessionInfo.getSessionKey(), encryptedData, ivStr);
            User user = userService.findBy("openid", sessionInfo.getOpenid());
            if (user == null) {
                user = new User(userInfo);


            }

        } catch (WxErrorException e) {
            this.logger.error(e.getMessage(), e);
        }
        return null;
    }
}
