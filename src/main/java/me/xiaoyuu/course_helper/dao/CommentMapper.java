package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.Comment;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

    List<Comment> selectByOwnerId(@Param("ownerId") String ownerId);

    List<String> selectHottest(@Param("num") int num);

    int isExisted(@Param("ownerId") String ownerId, @Param("fromId") int fromId);

    Double getAverageStar(@Param("ownerId") String ownerId);

    int removeLike(@Param("id") int id);

    int addLike(@Param("id") int id);
}