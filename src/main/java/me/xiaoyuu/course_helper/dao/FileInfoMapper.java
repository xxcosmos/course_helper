package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.FileInfo;
import org.apache.ibatis.annotations.Param;

import java.io.File;
import java.util.List;

public interface FileInfoMapper extends Mapper<FileInfo> {
    List<FileInfo> selectByOwnerIdAndType(@Param("ownerId") String ownerId, @Param("type") String type);

    Integer isExist(@Param("fileInfo") FileInfo fileInfo);

    int getFileCount(@Param("ownerId") String ownerId);

    int addDownloadCount(@Param("id") Integer id);
}