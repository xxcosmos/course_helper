package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.course_helper.service.GradeService;
import me.xiaoyuu.course_helper.vo.CourseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/11.
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Resource
    private CourseService courseService;
    @Resource
    private GradeService gradeService;


    @GetMapping("/{courseCode}")
    public Result detail(@PathVariable String courseCode) {
        if (StringUtils.isBlank(courseCode)) {
            return ResultGenerator.genFailResult("缺少参数");
        }

        Course course = courseService.findBy("courseCode", courseCode);
        List<TeacherInfoDTO> teacherList = gradeService.selectTeacherByCourseCode(courseCode);
        return ResultGenerator.genSuccessResult(new CourseVO(course, teacherList));
    }

    @GetMapping("/search")
    public Result search(@RequestParam String keyword) {
        logger.info(keyword);
        if (StringUtils.isBlank(keyword)) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        List<Course> courseList = courseService.findCourseListByKeyword(keyword);
        return ResultGenerator.genSuccessResult(courseList);
    }
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Course> list = courseService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
