package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.service.CommentService;
import me.xiaoyuu.course_helper.service.LikeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.course_helper.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/11.
 */
@RestController
@RequestMapping("/like")
public class LikeInfoController {

    private final Logger logger = LoggerFactory.getLogger(LikeInfoController.class);

    @Resource
    private LikeInfoService likeInfoService;
    @Resource
    private UserService userService;
    @Resource
    private JwtConfig jwtConfig;
    @Resource
    private CommentService commentService;

    @PostMapping
    public Result add(@RequestBody LikeInfo likeInfo, @RequestHeader String authorization) {
        if (likeInfo == null) {
            return ResultGenerator.genFailResult("参数");
        }


        int ownerId = likeInfo.getOwnerId();
        String openid = jwtConfig.getOpenIdByToken(authorization);
        int userId = userService.findBy("openid", openid).getId();
        likeInfo = likeInfoService.findByUserIdAndOwnerId(userId, ownerId);
        if (likeInfo != null) {
            likeInfoService.deleteById(likeInfo.getId());
            commentService.removeLike(ownerId);
        } else {
            likeInfo = new LikeInfo();
            likeInfo.setOwnerId(ownerId);
            likeInfo.setUserId(userId);
            likeInfoService.save(likeInfo);
            commentService.addLike(ownerId);
        }
        return ResultGenerator.genSuccessResult();
    }


}
