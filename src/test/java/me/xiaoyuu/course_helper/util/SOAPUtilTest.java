package me.xiaoyuu.course_helper.util;

import me.xiaoyuu.course_helper.CourseHelperApplicationTests;
import me.xiaoyuu.course_helper.dto.GradeAndCourseDTO;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.service.CourseService;
import me.xiaoyuu.course_helper.service.GradeService;
import me.xiaoyuu.course_helper.service.StudentService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.xml.soap.SOAPException;
import java.util.List;

public class SOAPUtilTest extends CourseHelperApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
    @Resource
    CourseService courseService;
    @Resource
    GradeService gradeService;
    @Resource
    StudentService studentService;



    @Test
    public void test2() {
        List<Student> studentList = studentService.findByGrade("2017");
        for (Student student : studentList) {
            String studentId = student.getStudentId();
            try {
                List<GradeAndCourseDTO> gradeAndCourseDTOList = ProcessUtil.processGradeAndChosenCourse(studentId);
                for (GradeAndCourseDTO gradeAndCourseDTO : gradeAndCourseDTOList) {
                    courseService.saveWithIgnore(gradeAndCourseDTO.getCourse());
                    gradeService.saveWithIgnore(gradeAndCourseDTO.getGrade());
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
    }


}