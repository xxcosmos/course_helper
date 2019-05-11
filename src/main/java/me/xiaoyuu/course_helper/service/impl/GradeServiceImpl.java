package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.GradeMapper;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.service.GradeService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class GradeServiceImpl extends AbstractService<Grade> implements GradeService {
    @Resource
    private GradeMapper gradeMapper;

}
