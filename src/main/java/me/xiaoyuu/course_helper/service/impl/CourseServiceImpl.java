package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.dao.CommentMapper;
import me.xiaoyuu.course_helper.dao.CourseMapper;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.CommentService;
import me.xiaoyuu.course_helper.service.CourseService;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import me.xiaoyuu.course_helper.service.GradeService;
import me.xiaoyuu.course_helper.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {
    private final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Resource
    private CourseMapper courseMapper;
    @Resource
    private CommentService commentService;
    @Resource
    private GradeService gradeService;
    @Resource
    private UserService userService;

    @Override
    public int saveWithIgnore(Course course) {
        return courseMapper.insertWithIgnore(course);
    }

    @Override
    public List<Course> findCourseListByKeyword(String keyword) {
        return courseMapper.selectListByKeyword(keyword);
    }

    public List<Course> getRecommendCourse(String openid) {
        //未登录
        if ("noOpenid".equals(openid)) {
            return this.findHottestCourse(10);
        }

        User user = userService.findBy("openid", openid);
        String studentId = user.getStudentId();

        //已登录 未绑定学号
        if (StringUtils.isBlank(studentId)) {
            return this.findHottestCourse(10);

        }
        //已登录 已绑定学号
        List<Grade> gradeList = gradeService.findByStudentId(studentId);
        //没有成绩信息
        if (gradeList.size() == 0) {
            return this.findHottestCourse(10);
        }
        //存在成绩信息
        List<Course> courseList = new ArrayList<>();
        for (Grade grade : gradeList) {
            if (gradeList.indexOf(grade) == 7) {
                break;
            }
            if (!commentService.isCommented(grade.getCourseCode(), user.getId())) {
                courseList.add(findBy("courseCode", grade.getCourseCode()));
            }
        }
        return courseList;
    }

    public List<Course> findHottestCourse(int num) {
        List<String> stringList = commentService.findHottest(num);
        List<Course> courseList = new ArrayList<>();
        for (String s : stringList) {
            Course course = findBy("courseCode", s);
            courseList.add(course);
        }
        return courseList;
    }
}
