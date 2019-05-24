package me.xiaoyuu.course_helper.dao;

import me.xiaoyuu.course_helper.core.Mapper;
import me.xiaoyuu.course_helper.model.FileInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileInfoMapper extends Mapper<FileInfo> {
    List<FileInfo> selectByOwnerIdAndType(@Param("ownerId") String ownerId, @Param("type") String type);

    int addDownloadCount(@Param("id") Integer id);
}