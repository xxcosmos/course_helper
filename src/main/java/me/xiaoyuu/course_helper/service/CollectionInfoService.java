package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.CollectionInfo;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/26.
 */
public interface CollectionInfoService extends Service<CollectionInfo> {
    int getCollectionCount(String ownerId, int type);

    boolean isExist(String ownerId, String token, int type);

    CollectionInfo getCollectionInfo(String ownerId, String token, int type);

    List<CollectionInfo> getUserCollectionList(Integer userId, int type);
}
