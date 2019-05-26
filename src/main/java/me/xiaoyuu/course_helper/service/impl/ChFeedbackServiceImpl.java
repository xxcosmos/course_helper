package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.ChFeedbackMapper;
import me.xiaoyuu.course_helper.model.ChFeedback;
import me.xiaoyuu.course_helper.service.ChFeedbackService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by xiaoyuu on 2019/05/26.
 */
@Service
@Transactional
public class ChFeedbackServiceImpl extends AbstractService<ChFeedback> implements ChFeedbackService {
    @Resource
    private ChFeedbackMapper chFeedbackMapper;

}
