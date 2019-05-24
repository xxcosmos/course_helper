package me.xiaoyuu.course_helper.service.impl;

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


    @Override
    public boolean isCommented(String ownerId, int fromId) {
        return commentMapper.isExisted(ownerId, fromId) > 0;
    }

    public List<Comment> findByOwnerId(String ownerId) {
        return commentMapper.selectByOwnerId(ownerId);
    }

    public List<CommentVO> getCommentVOByCourseCode(String courseCode) {
        List<Comment> commentList = findByOwnerId(courseCode);
        List<CommentVO> commentVOList = new ArrayList<>();
        for (Comment comment : commentList) {
            Integer userId = comment.getFromId();
            comment.setLikeNum(likeInfoService.getLikedCount(comment.getId()));

            CommentVO commentVO = new CommentVO();
            commentVO.setComment(comment);
            commentVO.setUserVO(new UserVO(userService.findBy("id", userId)));
            commentVO.setLike(likeInfoService.findByUserIdAndOwnerId(userId, comment.getId()) != null);
            commentVOList.add(commentVO);
        }
        return commentVOList;
    }

    public List<String> findHottest(int num) {
        return commentMapper.selectHottest(num);
    }

    public int getAverageStar(String ownerId) {
        Double averageStar = commentMapper.getAverageStar(ownerId);
        if (averageStar == null) {
            return 0;
        }
        return commentMapper.getAverageStar(ownerId).intValue();
    }


}
