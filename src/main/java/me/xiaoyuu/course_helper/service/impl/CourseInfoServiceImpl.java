package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.CourseInfoMapper;
import me.xiaoyuu.course_helper.model.CourseInfo;
import me.xiaoyuu.course_helper.service.CourseInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/10.
 */
@Service
@Transactional
public class CourseInfoServiceImpl extends AbstractService<CourseInfo> implements CourseInfoService {
    @Resource
    private CourseInfoMapper courseInfoMapper;

}
