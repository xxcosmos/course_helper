package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.Comment;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface CommentMapper extends Mapper<Comment> {
    List<Comment> selectByPid(@Param("pid") int pid);

    List<Comment> selectByOwnerIdAndType(@Param("ownerId") int ownerId, @Param("type") int type);
}