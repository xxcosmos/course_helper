package me.xiaoyuu.course_helper.util;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import me.xiaoyuu.course_helper.CourseHelperApplicationTests;
import me.xiaoyuu.course_helper.dto.CosCredential;
import me.xiaoyuu.course_helper.dto.GradeAndCourseDTO;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.CollectionInfo;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Student;
import me.xiaoyuu.course_helper.service.CollectionInfoService;
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

    @Resource
    CollectionInfoService collectionInfoService;

    @Test
    public void test2() {
//        List<Student> studentList = studentService.findByGrade("2014");
        ExcelReader reader = ExcelUtil.getReader(ResourceUtil.getStream("nameList.xlsx"));
        List<Student> studentList = reader.readAll(Student.class);
        for (Student student : studentList) {
            studentService.saveIgnore(student);
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

    @Test
    public void test3() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcGVuaWQiOiJvbzRLYTVZajFWOHZ6d2JoS3Q3NHZ5YnBuN3lnIiwiZXhwIjoxNTU4ODU4MTcxLCJqd3RJZCI6IjcyYzBjNWE4LTNhOTMtNDg4OS1iYTRmLWJjYzc2ZTRkZDM3MyJ9.lyMbwx7s_tmTOSwO4m9MmrDP3ftJb2tczNGIzM9yNXU";

        boolean exist = collectionInfoService.isExist("0603016", token, 0);
        System.out.println(exist);
    }

    @Test
    public void test4() {
        ExcelReader reader = ExcelUtil.getReader(ResourceUtil.getStream("nameList.xlsx"));
        List<Student> students = reader.readAll(Student.class);
        for (Student student : students) {
            System.out.println(student);
            if (students.indexOf(student) == 10) {
                break;
            }
        }
    }


}