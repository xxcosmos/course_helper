package me.xiaoyuu.course_helper.util;

import me.xiaoyuu.course_helper.CourseHelperApplicationTests;
import me.xiaoyuu.course_helper.dto.GradeInfoDTO;
import me.xiaoyuu.course_helper.model.GradeInfo;
import me.xiaoyuu.course_helper.model.StudentInfo;
import me.xiaoyuu.course_helper.service.GradeInfoService;
import me.xiaoyuu.course_helper.service.StudentInfoService;
import org.junit.Test;

import javax.annotation.Resource;
import javax.xml.soap.SOAPException;
import java.util.ArrayList;
import java.util.List;

public class SOAPUtilTest extends CourseHelperApplicationTests {

    @Resource
    StudentInfoService studentInfoService;
    @Resource
    GradeInfoService gradeInfoService;
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
        StudentInfo info = studentInfoService.findById(19);
        System.out.println(info.getStudentId() + info.getStudentName());
        GradeInfo gradeInfo = new GradeInfo();
        gradeInfo.setCourseName("sss");
        gradeInfoService.save(gradeInfo);

    }
}