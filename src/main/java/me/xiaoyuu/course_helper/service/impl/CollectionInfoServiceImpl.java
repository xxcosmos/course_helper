package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.dao.CollectionInfoMapper;
import me.xiaoyuu.course_helper.model.CollectionInfo;
import me.xiaoyuu.course_helper.service.CollectionInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import me.xiaoyuu.course_helper.service.UserService;
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

        String openId = jwtConfig.getOpenIdByToken(token);
        Integer userId = userService.getUserIdByOpenId(openId);
        if (userId == null) {
            return null;
        }

        return new CollectionInfo(ownerId, userId, type);
    }

    public List<CollectionInfo> getUserCollectionList(Integer userId, int type) {
        return collectionInfoMapper.selectByUserIdAndType(userId, type);
    }
}
