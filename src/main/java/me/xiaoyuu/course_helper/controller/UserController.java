package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.dto.WeixinAuthDTO;
import me.xiaoyuu.course_helper.dto.WeixinLoginDTO;
import me.xiaoyuu.course_helper.dto.UserInfo;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.StudentService;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.service.WeixinService;
import me.xiaoyuu.course_helper.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Created by xiaoyuu on 2019/05/11.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Resource
    private WeixinService weixinService;
    @Resource
    JwtConfig jwtConfig;

    @IgnoreAuth
    @PostMapping("/login")
    public Result login(@RequestBody WeixinLoginDTO weixinLoginDTO) {
        String code = weixinLoginDTO.getCode();
        UserInfo userInfo = weixinLoginDTO.getUserInfo();
        logger.info(code);
        logger.info("userInfo   " + userInfo.getNickName());
        WeixinAuthDTO weixinAuthDTO = weixinService.getWeixinAuthDTO(code);
        logger.info(weixinAuthDTO.toString());
        if (weixinAuthDTO == null || weixinAuthDTO.getErrcode() != 0) {
            return ResultGenerator.genFailResult("验证code错误");
        }
        //验证code正确
        User user = userService.findBy("openid", weixinAuthDTO.getOpenid());
        if (user == null) {
            //新注册
            user = weixinService.getUser(weixinAuthDTO, userInfo);
            userService.save(user);
        }


        String token = jwtConfig.generateToken(user);
        return ResultGenerator.genSuccessResult(token);

    }

    @GetMapping
    public Result getUserInfo(@RequestHeader String authorization) {
        String openid = jwtConfig.getOpenIdByToken(authorization);
        User user = userService.findBy("openid", openid);
        UserVO userVO = new UserVO(user);
        return ResultGenerator.genSuccessResult(userVO);
    }

    @PostMapping("/bind")
    public Result bind(@RequestBody Student student, @RequestHeader String authorization) {
        logger.info(student.getStudentId());
        String openid = jwtConfig.getOpenIdByToken(authorization);
        return userService.bind(openid, student);
    }
}
