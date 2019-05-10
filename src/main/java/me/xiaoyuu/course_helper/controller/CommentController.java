package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.course_helper.vo.CommentVO;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/09.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping
    public Result add(Comment comment) {
        commentService.save(comment);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        commentService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 得到课程评论列表
     *
     * @param id
     * @return
     */
    @GetMapping("/course/{id}")
    public Result getCourseComments(@PathVariable Integer id) {
        List<Comment> comments = commentService.findByOwnerIdAndType(id, 1);
        return ResultGenerator.genSuccessResult(comments);
    }

    /**
     * 得到评论详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getCommentDetail(@PathVariable Integer id) {
        Comment comment = commentService.findById(id);
        if (comment == null)
            return ResultGenerator.genFailResult("请求参数不合法");

        List<Comment> childComment = commentService.findByPid(comment.getId());
        CommentVO commentVO = new CommentVO(comment, childComment);

        return ResultGenerator.genSuccessResult(commentVO);
    }
}
