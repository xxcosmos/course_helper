package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dao.GradeMapper;
import me.xiaoyuu.course_helper.dto.GradeAndCourseDTO;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.service.CourseService;
import me.xiaoyuu.course_helper.service.GradeService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import me.xiaoyuu.course_helper.service.StudentService;
import me.xiaoyuu.course_helper.util.ProcessUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.soap.SOAPException;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class GradeServiceImpl extends AbstractService<Grade> implements GradeService {
    @Resource
    private GradeMapper gradeMapper;
    @Resource
    private StudentService studentService;
    @Resource
    private CourseService courseService;
    @Resource
    private GradeService gradeService;

    @Override
    public List<TeacherInfoDTO> findTeacherInfoByCourseCode(String courseCode) {
        List<TeacherInfoDTO> teacherInfoDTOList = gradeMapper.selectTeacherInfoByCourseCode(courseCode);
        int deleted = -1;
        for (TeacherInfoDTO teacherInfoDTO : teacherInfoDTOList) {
            if (teacherInfoDTO.getTeacherName() == null) {
                deleted = teacherInfoDTOList.indexOf(teacherInfoDTO);
                break;
            }
        }
        if (deleted != -1) {
            teacherInfoDTOList.remove(deleted);
        }

        return teacherInfoDTOList;
    }

    public List<Grade> findByStudentId(String studentId) {
        return gradeMapper.selectByStudentId(studentId);
    }
    @Override
    public int saveWithIgnore(Grade grade) {
        return gradeMapper.insertWithIgnore(grade);
    }

    public void saveGradeAndCourseByGrade(String grade) throws SOAPException {
        List<Student> studentList = studentService.findByGrade(grade);
        for (Student student : studentList) {
            List<GradeAndCourseDTO> gradeAndCourseDTOList = ProcessUtil.processGradeAndChosenCourse(student.getStudentId());
            for (GradeAndCourseDTO gradeAndCourseDTO : gradeAndCourseDTOList) {
                courseService.saveWithIgnore(gradeAndCourseDTO.getCourse());
                gradeService.saveWithIgnore(gradeAndCourseDTO.getGrade());
            }

        }
    }
}
