package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.dao.CommentMapper;
import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.CommentService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import me.xiaoyuu.course_helper.service.LikeInfoService;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.vo.CommentVO;
import me.xiaoyuu.course_helper.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/09.
 */
@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private LikeInfoService likeInfoService;
    @Resource
    private UserService userService;
    @Resource
    private JwtConfig jwtConfig;
    @Override
    public int addLike(int id) {
        return commentMapper.addLike(id);
    }

    @Override
    public int removeLike(int id) {
        return commentMapper.removeLike(id);
    }

    @Override
    public boolean isCommented(String ownerId, int fromId) {
        return commentMapper.isExisted(ownerId, fromId) != null;
    }

    public List<Comment> findByOwnerId(String ownerId) {
        return commentMapper.selectByOwnerId(ownerId);
    }

    public List<CommentVO> getCommentVO(String courseCode, String token) {
        //拿到该课程下的所有评论
        List<Comment> commentList = findByOwnerId(courseCode);
        List<CommentVO> commentVOList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVO commentVO = new CommentVO();
            commentVO.setUserVO(new UserVO(userService.findBy("id", comment.getFromId())));
            commentVO.setComment(comment);
            if (token == null) {
                commentVO.setLike(false);
            } else {
                int userId = userService.findBy("openid", jwtConfig.getOpenIdByToken(token)).getId();
                commentVO.setLike(likeInfoService.findByUserIdAndOwnerIdAndType(userId, comment.getId(), 0) != null);
            }
            commentVOList.add(commentVO);
        }
        return commentVOList;
    }

    public List<String> findHottest(int num) {
        return commentMapper.selectHottest(num);
    }

    public int getAverageRate(String ownerId) {
        Double averageRate = commentMapper.getAverageRate(ownerId);
        if (averageRate == null) {
            return 0;
        }
        return averageRate.intValue();
    }

    @Override
    public int getCount(String ownerId) {
        return commentMapper.getCommentCount(ownerId);
    }
}
