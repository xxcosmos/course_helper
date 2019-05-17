package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.core.service.Service;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface LikeInfoService extends Service<LikeInfo> {
    int getLikedCount(int id);

    List<LikeInfo> findByUserIdAndOwnerId(int userId, int ownerId);
}
