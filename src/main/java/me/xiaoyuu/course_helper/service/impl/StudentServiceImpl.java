package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.StudentMapper;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.service.StudentService;
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
public class StudentServiceImpl extends AbstractService<Student> implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public int saveIgnore(Student student) {
        return studentMapper.insertIgnore(student);
    }

    @Override
    public List<Student> findByGrade(String grade) {
        return studentMapper.selectByGrade(grade);
    }
}
