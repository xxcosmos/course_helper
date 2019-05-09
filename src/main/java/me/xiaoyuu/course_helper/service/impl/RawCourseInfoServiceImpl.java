package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.RawCourseInfoMapper;
import me.xiaoyuu.course_helper.model.RawCourseInfo;
import me.xiaoyuu.course_helper.service.RawCourseInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/08.
 */
@Service
@Transactional
public class RawCourseInfoServiceImpl extends AbstractService<RawCourseInfo> implements RawCourseInfoService {
    @Resource
    private RawCourseInfoMapper rawCourseInfoMapper;

    public int savetWithIgnore(RawCourseInfo rawCourseInfo) {
        return rawCourseInfoMapper.insertWithIgnore(rawCourseInfo);
    }
}
