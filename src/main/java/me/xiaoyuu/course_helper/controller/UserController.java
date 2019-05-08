package me.xiaoyuu.course_helper.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import me.chanjar.weixin.common.error.WxErrorException;
import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.dto.WeixinAuthDTO;
import me.xiaoyuu.course_helper.dto.WeixinUserInfoDTO;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.service.WeixinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Created by xiaoyuu on 2019/05/07.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
    @Resource
    private UserService userService;

    @Resource
    private WeixinService weixinService;
    @Resource
    JwtConfig jwtConfig;

    @IgnoreAuth
    @PostMapping("/login")
    public Result login(String jscode, WeixinUserInfoDTO weixinUserInfoDTO) {
        logger.info(jscode);
        WeixinAuthDTO weixinAuthDTO = weixinService.getWeixinAuthDTO(jscode);
        if (weixinAuthDTO == null || weixinAuthDTO.getErrcode() != 0) {
            return ResultGenerator.genFailResult("验证code错误");
        }
        //验证code正确
        User user = userService.findBy("openid", weixinAuthDTO.getOpenid());
        if (user == null) {
            //新注册
            user = weixinService.getUser(weixinAuthDTO, weixinUserInfoDTO);
            userService.save(user);
        }
        String token = jwtConfig.generateToken(user);
        return ResultGenerator.genSuccessResult(token);

    }


    @GetMapping("/hello")
    public Result sayHello(@RequestHeader(name = "authorization") String token) {
        String openId = jwtConfig.getOpenIdByToken(token);
        return ResultGenerator.genSuccessResult(openId);
    }
}
