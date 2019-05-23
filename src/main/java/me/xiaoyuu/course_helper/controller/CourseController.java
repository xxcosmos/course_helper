package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.service.CommentService;
import me.xiaoyuu.course_helper.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.course_helper.service.GradeService;
import me.xiaoyuu.course_helper.service.UserService;
import me.xiaoyuu.course_helper.vo.CommentVO;
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
    @Resource
    private CommentService commentService;
    @Resource
    JwtConfig jwtConfig;
    @Resource
    private UserService userService;

    /**
     * 课程详情
     *
     * @param courseCode
     * @return
     */
    @GetMapping("/{courseCode}")
    public Result detail(@PathVariable String courseCode) {
        if (StringUtils.isBlank(courseCode)) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        List<CommentVO> commentVOList = commentService.getCommentVOByCourseCode(courseCode);
        Course course = courseService.findBy("courseCode", courseCode);
        List<TeacherInfoDTO> teacherList = gradeService.findTeacherInfoByCourseCode(courseCode);
        return ResultGenerator.genSuccessResult(new CourseVO(course, teacherList, commentVOList));
    }

    /**
     * 热门课程
     * @return
     */
    @GetMapping("/hot")
    public Result hottestCourse() {
        List<Course> hottestCourse = courseService.findHottestCourse(50);
        return ResultGenerator.genSuccessResult(hottestCourse);
    }

    /**
     * 推荐课程
     * @param authorization
     * @return
     */
    @GetMapping("/recommend")
    public Result recommendCourse(@RequestHeader String authorization) {
        String openid = jwtConfig.getOpenIdByToken(authorization);
        List<Course> courseList = courseService.getRecommendCourse(openid);
        return ResultGenerator.genSuccessResult(courseList);

    }

    /**
     * 对课程名模糊查询
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public Result search(@RequestParam String keyword) {
        logger.info(keyword);
        if (StringUtils.isBlank(keyword)) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        List<Course> courseList = courseService.findCourseListByKeyword(keyword);
        return ResultGenerator.genSuccessResult(courseList);
    }

    /**
     * 得到全部课程
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Course> list = courseService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
