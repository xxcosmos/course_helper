package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.controller.CollectionInfoController;
import me.xiaoyuu.course_helper.dao.CollectionInfoMapper;
import me.xiaoyuu.course_helper.model.CollectionInfo;
import me.xiaoyuu.course_helper.service.CollectionInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import me.xiaoyuu.course_helper.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/26.
 */
@Service
@Transactional
public class CollectionInfoServiceImpl extends AbstractService<CollectionInfo> implements CollectionInfoService {
    private final Logger logger = LoggerFactory.getLogger(CollectionInfoServiceImpl.class);

    @Resource
    private CollectionInfoMapper collectionInfoMapper;
    @Resource
    private JwtConfig jwtConfig;
    @Resource
    private UserService userService;

    public int getCollectionCount(String ownerId, int type) {
        CollectionInfo collectionInfo = new CollectionInfo(ownerId, type);

        return collectionInfoMapper.getCollectionCount(collectionInfo);
    }

    public boolean isExist(String ownerId, String token, int type) {
        return getCollectionInfo(ownerId, token, type) != null;
    }

    public CollectionInfo getCollectionInfo(String ownerId, String token, int type) {
        if (token == null) {
            return null;
        }

        Integer userId = userService.getUserIdByToken(token);
        if (userId == null) {
            return null;
        }

        CollectionInfo collectionInfo = new CollectionInfo(ownerId, userId, type);
        return collectionInfoMapper.selectByUserIdAndOwnerIdAndType(collectionInfo);
    }

    public List<CollectionInfo> getUserCollectionList(Integer userId, int type) {
        return collectionInfoMapper.selectByUserIdAndType(userId, type);
    }
}
