package me.xiaoyuu.course_helper.util;

import me.xiaoyuu.course_helper.dto.ChosenCourseDTO;
import me.xiaoyuu.course_helper.dto.GradeInfoDTO;

import javax.xml.soap.SOAPException;
import java.util.List;

public class ProcessUtil {

    public static void processGradeAndChosenCourse(String studentId) throws SOAPException {
        //得到学生所有的成绩和已选列表
        List<GradeInfoDTO> studentGradeDTOList = SoapUtil.getStudentGradeDTOList(studentId);
        List<ChosenCourseDTO> allChosenCourseDTOList = SoapUtil.getAllChosenCourseDTOList(studentId);

        for (GradeInfoDTO gradeInfoDTO : studentGradeDTOList) {
            ChosenCourseDTO chosenCourseDTO = findChosenCourseByName(gradeInfoDTO.getKcmc(), allChosenCourseDTOList);


        }
    }

    private static ChosenCourseDTO findChosenCourseByName(String courseName, List<ChosenCourseDTO> chosenCourseDTOList) {
        for (ChosenCourseDTO chosenCourseDTO : chosenCourseDTOList) {
            if (chosenCourseDTO.getKcmc().contains(courseName) || courseName.contains(chosenCourseDTO.getKcmc())) {
                return chosenCourseDTO;
            }
        }
        return null;
    }
}

