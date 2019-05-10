package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/09.
 */
public interface CommentService extends Service<Comment> {
    List<Comment> findByPid(int pid);

    List<Comment> findByOwnerIdAndType(int ownerId, int type);
}
