package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.service.LikeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.course_helper.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/11.
 */
@RestController
@RequestMapping("/like")
public class LikeInfoController {
    @Resource
    private LikeInfoService likeInfoService;
    @Resource
    private UserService userService;
    @Resource
    private JwtConfig jwtConfig;

    @PostMapping
    public Result add(@RequestBody LikeInfo likeInfo, @RequestHeader String authorization) {
        if (likeInfo == null || likeInfo.getOwnerId() == null) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        String openid = jwtConfig.getOpenIdByToken(authorization);
        int userId = userService.findBy("openid", openid).getId();
        likeInfo.setUserId(userId);
        likeInfoService.save(likeInfo);

        return ResultGenerator.genSuccessResult();
    }


}
