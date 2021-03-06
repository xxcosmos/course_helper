package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.service.CommentService;
import me.xiaoyuu.course_helper.service.LikeInfoService;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.vo.CommentVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/09.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private CommentService commentService;
    @Resource
    private LikeInfoService likeInfoService;
    @Resource
    private UserService userService;
    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Comment comment) {
        logger.info(comment.toString());
        if (StringUtils.isBlank(comment.getContent())) {
            return ResultGenerator.genFailResult("评论内容为空");
        }
        if (comment.getFromId() == null || comment.getOwnerId() == null) {
            return ResultGenerator.genFailResult("请求参数有误");
        }
        commentService.save(comment);
        return ResultGenerator.genSuccessResult("success");
    }

    /**
     * 通过评论id 删除评论
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result delete(@PathVariable Integer id, @RequestHeader String authorization) {

        Comment comment = commentService.findById(id);
        if (comment == null) {
            return ResultGenerator.genFailResult("不存在");
        }

        if (!comment.getFromId().equals(userService.getUserIdByToken(authorization))) {
            return ResultGenerator.genFailResult("权限错误");
        }
        commentService.deleteById(id);
        return ResultGenerator.genSuccessResult("success");
    }


}
