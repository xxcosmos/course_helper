package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.GradeInfoMapper;
import me.xiaoyuu.course_helper.model.GradeInfo;
import me.xiaoyuu.course_helper.service.GradeInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/08.
 */
@Service
@Transactional
public class GradeInfoServiceImpl extends AbstractService<GradeInfo> implements GradeInfoService {
    @Resource
    private GradeInfoMapper gradeInfoMapper;

}
