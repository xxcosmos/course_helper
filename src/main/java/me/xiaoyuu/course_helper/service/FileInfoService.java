package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.FileInfo;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/24.
 */
public interface FileInfoService extends Service<FileInfo> {
    boolean isFileValidated(FileInfo fileInfo);

    FileInfo completeFileInfo(FileInfo fileInfo, int userId);

    boolean isExist(FileInfo fileInfo);

    List<FileInfo> findByOwnerIdAndType(String ownerId);

    int getFileCount(String ownerId);
    void addDownloadCount(Integer id);
}
