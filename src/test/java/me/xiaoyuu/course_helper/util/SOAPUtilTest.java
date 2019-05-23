package me.xiaoyuu.course_helper.util;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import me.xiaoyuu.course_helper.CourseHelperApplicationTests;
import me.xiaoyuu.course_helper.dto.CosCredential;
import me.xiaoyuu.course_helper.dto.GradeAndCourseDTO;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
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
import java.time.LocalTime;
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
        List<Student> studentList = studentService.findByGrade("2015");
        for (Student student : studentList) {
            String studentId = student.getStudentId();
            logger.info(studentId);
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

    @Test
    public void test3() {

        List<Course> courseList = courseService.findCourseListByKeyword("1");
        for (Course course : courseList) {
            System.out.println(course.getCourseName() + course.getCourseCredit());
        }
    }

    @Test
    public void test4() {
        String fileName = "abc.jpg";
        System.out.println(fileName.split("\\.")[1]);
    }


}