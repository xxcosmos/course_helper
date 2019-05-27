package me.xiaoyuu.course_helper.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import me.xiaoyuu.course_helper.dao.FileInfoMapper;
import me.xiaoyuu.course_helper.model.FileInfo;
import me.xiaoyuu.course_helper.service.FileInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/24.
 */
@Service
@Transactional
public class FileInfoServiceImpl extends AbstractService<FileInfo> implements FileInfoService {
    @Resource
    private FileInfoMapper fileInfoMapper;

    public boolean isFileValidated(FileInfo fileInfo) {
        return !(!containExtension(fileInfo.getFileName()) || StringUtils.isBlank(fileInfo.getOwnerId()) || StringUtils.isBlank(fileInfo.getFileDescription()) || fileInfo.getSize() <= 0);
    }

    @Override
    public int getFileCount(String ownerId) {
        return fileInfoMapper.getFileCount(ownerId);
    }

    public boolean isExist(FileInfo fileInfo) {
        return fileInfoMapper.isExist(fileInfo) != null;
    }

    public void addDownloadCount(Integer id) {
        fileInfoMapper.addDownloadCount(id);
    }

    @Override
    public List<FileInfo> findByOwnerIdAndType(String ownerId) {
        return fileInfoMapper.selectByOwnerIdAndType(ownerId);
    }

    public boolean containExtension(String fileName) {
        if (StrUtil.isBlank(fileName)) {
            return false;
        }
        String[] split = fileName.split("\\.");
        return split.length > 1;

    }

    public FileInfo completeFileInfo(FileInfo fileInfo, int userId) {

        String cosName = IdUtil.simpleUUID();
        String[] split = fileInfo.getFileName().split("\\.");
        String fileType = split[split.length - 1];
        if (fileType != null) {
            fileInfo.setCosName(cosName + "." + fileType);
        } else {
            fileInfo.setCosName(cosName);
        }
        fileInfo.setFromId(userId);
        return fileInfo;
    }
}
