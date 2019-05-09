package me.xiaoyuu.course_helper.util;

import me.xiaoyuu.course_helper.CourseHelperApplicationTests;
import me.xiaoyuu.course_helper.dto.ChosenCourseDTO;
import me.xiaoyuu.course_helper.dto.GradeInfoDTO;
import me.xiaoyuu.course_helper.model.GradeInfo;
import me.xiaoyuu.course_helper.model.RawCourseInfo;
import me.xiaoyuu.course_helper.model.StudentInfo;
import me.xiaoyuu.course_helper.service.GradeInfoService;
import me.xiaoyuu.course_helper.service.RawCourseInfoService;
import me.xiaoyuu.course_helper.service.StudentInfoService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.xml.soap.SOAPException;
import java.util.ArrayList;
import java.util.List;

public class SOAPUtilTest extends CourseHelperApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Resource
    StudentInfoService studentInfoService;
    @Resource
    GradeInfoService gradeInfoService;
    @Resource
    RawCourseInfoService rawCourseInfoService;
    @Test
    public void getStudentGradeList() {
        List<StudentInfo> studentInfos = studentInfoService.findAll();
        for (StudentInfo studentInfo : studentInfos) {
            String studentId = studentInfo.getStudentId();

            System.out.println("start" + studentId);
            try {
                List<GradeInfoDTO> studentGradeDTOList = SoapUtil.getStudentGradeDTOList(studentId);

                for (GradeInfoDTO gradeInfoDTO : studentGradeDTOList) {
                    GradeInfo gradeInfo = new GradeInfo();

                    gradeInfo.setCjbsmc(gradeInfoDTO.getCjbsmc());
                    gradeInfo.setCourseCredit(String.valueOf(gradeInfoDTO.getXf()));
                    gradeInfo.setCourseHour(gradeInfoDTO.getZxs());
                    gradeInfo.setCourseName(gradeInfoDTO.getKcmc());
                    gradeInfo.setCourseType(gradeInfoDTO.getKclbmc());
                    gradeInfo.setCourseTypeName(gradeInfoDTO.getKcxzmc());
                    gradeInfo.setGrade(gradeInfoDTO.getZcj());
                    gradeInfo.setJd(gradeInfoDTO.getJd());
                    gradeInfo.setStudentId(gradeInfoDTO.getXh());
                    gradeInfo.setTestType(gradeInfoDTO.getKsxzmc());
                    gradeInfo.setXq(gradeInfoDTO.getXq());

                    gradeInfoService.save(gradeInfo);
                }
                System.out.println(studentId);
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        List<StudentInfo> studentInfos = studentInfoService.findAll();
        for (StudentInfo studentInfo : studentInfos) {
            try {
                List<ChosenCourseDTO> chosenCourseDTOList = SoapUtil.getAllChosenCourseDTOList(studentInfo.getStudentId());
                if (chosenCourseDTOList == null) {
                    logger.error(studentInfo.getStudentId());
                    continue;
                }
                for (ChosenCourseDTO chosenCourseDTO : chosenCourseDTOList) {
                    RawCourseInfo rawCourseInfo = new RawCourseInfo();
                    rawCourseInfo.setCourseCode(chosenCourseDTO.getKch());
                    rawCourseInfo.setTeacherName(chosenCourseDTO.getJsxm());
                    rawCourseInfo.setCourseCredit(String.valueOf(chosenCourseDTO.getXf()));
                    rawCourseInfo.setCourseHour(chosenCourseDTO.getZxs());
                    rawCourseInfo.setCourseName(chosenCourseDTO.getKcmc());
                    rawCourseInfo.setCourseType(chosenCourseDTO.getKcsxm());
                    rawCourseInfo.setCourseTypeCode(chosenCourseDTO.getKcxzm());
                    rawCourseInfo.setCourseTypeName(chosenCourseDTO.getKcxzmc());
                    rawCourseInfo.setKcsx(chosenCourseDTO.getKcsx());
                    rawCourseInfo.setSzkcfl(chosenCourseDTO.getSzkcfl());
                    rawCourseInfo.setUnitName(chosenCourseDTO.getDwmc());
                    rawCourseInfoService.savetWithIgnore(rawCourseInfo);
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
    }
}