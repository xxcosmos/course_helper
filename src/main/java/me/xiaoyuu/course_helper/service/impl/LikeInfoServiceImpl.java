package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.LikeInfoMapper;
import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.service.LikeInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class LikeInfoServiceImpl extends AbstractService<LikeInfo> implements LikeInfoService {
    @Resource
    private LikeInfoMapper likeInfoMapper;


    public int getLikedCount(int id) {
        return likeInfoMapper.getLikedCount(id);
    }


    @Override
    public LikeInfo findByUserIdAndOwnerIdAndType(int userId, int ownerId, int type) {
        return likeInfoMapper.selectByUserIdAndOwnerIdAndType(ownerId, userId, type);
    }
}
