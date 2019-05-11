package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.CommentMapper;
import me.xiaoyuu.course_helper.model.Comment;
import me.xiaoyuu.course_helper.service.CommentService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/09.
 */
@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    public List<Comment> findByPid(int pid) {
        return commentMapper.selectByPid(pid);
    }

    public List<Comment> findByOwnerIdAndType(int ownerId, int type) {
        return commentMapper.selectByOwnerIdAndType(ownerId, type);
    }

    public void deleteCascadeById(int id) {
        List<Comment> commentList = findByPid(id);
        for (Comment comment : commentList) {
            deleteById(comment.getId());
        }
        deleteById(id);

    }

}
