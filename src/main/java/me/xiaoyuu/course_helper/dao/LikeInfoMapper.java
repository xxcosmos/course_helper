package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.LikeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LikeInfoMapper extends Mapper<LikeInfo> {
    int getLikedCount(@Param("id") int id);

    LikeInfo selectByUserIdAndOwnerId(@Param("ownerId") int ownerId, @Param("userId") int userId);
}