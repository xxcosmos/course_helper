package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.CollectionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionInfoMapper extends Mapper<CollectionInfo> {
    int getCollectionCount(@Param("collectionInfo") CollectionInfo collectionInfo);

    CollectionInfo selectByUserIdAndOwnerIdAndType(@Param("collectionInfo") CollectionInfo collectionInfo);

    List<CollectionInfo> selectByUserIdAndType(@Param("userId") Integer userId, @Param("type") int type);
}