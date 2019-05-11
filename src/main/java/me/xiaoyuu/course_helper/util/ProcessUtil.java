package me.xiaoyuu.course_helper.util;

import me.xiaoyuu.course_helper.dto.ChosenCourseDTO;
import me.xiaoyuu.course_helper.dto.GradeAndCourseDTO;
import me.xiaoyuu.course_helper.dto.GradeInfoDTO;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Grade;

import javax.xml.soap.SOAPException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessUtil {

    public static List<GradeAndCourseDTO> processGradeAndChosenCourse(String studentId) throws SOAPException {
        //得到学生所有的成绩和已选列表
        List<GradeInfoDTO> studentGradeDTOList = SoapUtil.getStudentGradeDTOList(studentId);
        List<ChosenCourseDTO> allChosenCourseDTOList = SoapUtil.getAllChosenCourseDTOList(studentId);
        List<GradeAndCourseDTO> gradeAndCourseDTOList = new ArrayList<>();
        for (GradeInfoDTO gradeInfoDTO : studentGradeDTOList) {
            ChosenCourseDTO chosenCourseDTO = findChosenCourseByName(gradeInfoDTO.getKcmc(), allChosenCourseDTOList);
            if (chosenCourseDTO == null) {
                continue;
            }
            Course course = dtoToCourse(gradeInfoDTO, chosenCourseDTO);
            Grade grade = dtoToGrade(gradeInfoDTO, chosenCourseDTO);
            gradeAndCourseDTOList.add(new GradeAndCourseDTO(grade, course));
        }

        return gradeAndCourseDTOList;
    }

    private static Course dtoToCourse(GradeInfoDTO gradeInfoDTO, ChosenCourseDTO chosenCourseDTO) {
        Course course = new Course();
        course.setCourseType(getCourseType(chosenCourseDTO.getKcsxm()));
        course.setCourseName(chosenCourseDTO.getKcmc());
        course.setCourseHour(chosenCourseDTO.getZxs());
        course.setCourseCredit(chosenCourseDTO.getXf());
        course.setCourseCode(chosenCourseDTO.getKch());
        course.setCourseTypeName(chosenCourseDTO.getKcxzmc());
        course.setUnitName(chosenCourseDTO.getDwmc());
        return course;
    }

    private static int getCourseType(String type) {
        if ("必修".equals(type)) {
            return 1;
        }
        if ("选修".equals(type)) {
            return 2;
        }
        return 0;
    }

    private static Grade dtoToGrade(GradeInfoDTO gradeInfoDTO, ChosenCourseDTO chosenCourseDTO) {
        Grade grade = new Grade();

        grade.setCourseCode(chosenCourseDTO.getKch());
        grade.setGrade(gradeInfoDTO.getZcj());
        grade.setGradePoint(gradeInfoDTO.getJd());
        grade.setGradeTypeName(gradeInfoDTO.getKsxzmc());
        grade.setStudentId(gradeInfoDTO.getXh());
        grade.setTeacherName(chosenCourseDTO.getJsxm());
        return grade;
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

