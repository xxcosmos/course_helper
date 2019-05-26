package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.core.service.Service;
import me.xiaoyuu.course_helper.vo.CommentVO;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/09.
 */
public interface CommentService extends Service<Comment> {


    List<Comment> findByOwnerId(String ownerId);

    List<String> findHottest(int num);

    int getCount(String ownerId);

    List<CommentVO> getCommentVO(String courseCode, String token);

    boolean isCommented(String ownerId, int fromId);

    int getAverageRate(String ownerId);

    int addLike(int id);

    int removeLike(int id);
}
