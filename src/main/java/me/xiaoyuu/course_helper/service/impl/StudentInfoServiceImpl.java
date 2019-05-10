package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.StudentInfoMapper;
import me.xiaoyuu.course_helper.model.StudentInfo;
import me.xiaoyuu.course_helper.service.StudentInfoService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/08.
 */
@Service
@Transactional
public class StudentInfoServiceImpl extends AbstractService<StudentInfo> implements StudentInfoService {
    @Resource
    private StudentInfoMapper studentInfoMapper;


    public List<StudentInfo> findByGrade(String grade) {
        return studentInfoMapper.selectByGrade(grade);
    }

}
