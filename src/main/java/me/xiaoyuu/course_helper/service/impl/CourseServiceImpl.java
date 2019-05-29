package me.xiaoyuu.course_helper.service.impl;

import cn.hutool.core.util.RandomUtil;
import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.dao.CommentMapper;
import me.xiaoyuu.course_helper.dao.CourseMapper;
import me.xiaoyuu.course_helper.dto.TeacherInfoDTO;
import me.xiaoyuu.course_helper.model.CollectionInfo;
import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.model.Grade;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.*;
import me.xiaoyuu.course_helper.core.service.AbstractService;
import me.xiaoyuu.course_helper.vo.CommentVO;
import me.xiaoyuu.course_helper.vo.CourseVO;
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
    @Resource
    private JwtConfig jwtConfig;
    @Resource
    private FileInfoService fileInfoService;
    @Resource
    private CollectionInfoService collectionInfoService;

    @Override
    public int saveWithIgnore(Course course) {
        return courseMapper.insertWithIgnore(course);
    }

    @Override
    public List<CourseVO> findCourseListByKeyword(String keyword) {

        List<Course> courseList = courseMapper.selectListByKeyword(keyword);
        List<CourseVO> courseVOList = new ArrayList<>();
        for (Course course : courseList) {
            courseVOList.add(getCourseVO(course.getCourseCode()));
        }
        return courseVOList;
    }

    public List<CourseVO> selectByCollegeCode(String collegeCode) {
        List<Course> courseList = courseMapper.selectByCollegeCode(collegeCode);
        List<CourseVO> courseVOList = new ArrayList<>();
        for (Course course : courseList) {
            courseVOList.add(getCourseVO(course.getCourseCode()));
        }
        return courseVOList;
    }

    /**
     * 随机获取课程
     *
     * @return
     */
    public List<CourseVO> getRandomCourseVOList() {
        List<Course> courseList = courseMapper.selectByCourseTypeName("学科基础平台课程");
        courseList.addAll(courseMapper.selectByCourseTypeName("通识教育平台课程"));
        List<CourseVO> courseVOList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randomInt = RandomUtil.randomInt(0, courseList.size() - 1);
            CourseVO courseVO = getCourseVO(courseList.get(randomInt).getCourseCode());
            courseVOList.add(courseVO);
        }
        return courseVOList;
    }

    /**
     * 推荐课程
     *
     * @param token
     * @return
     */
    public List<CourseVO> getRecommendCourse(String token) {
        if (token == null) {
            return getRandomCourseVOList();
        }
        String openid = jwtConfig.getOpenIdByToken(token);
        if (openid == null) {
            //未登录
            return this.findHottestCourse(10);
        }

        User user = userService.findBy("openid", openid);
        String studentId = user.getStudentId();
        if (StringUtils.isBlank(studentId)) {
            //已登录 未绑定学号
            return getRandomCourseVOList();
        }

        List<Grade> gradeList = gradeService.findByStudentId(studentId);
        if (gradeList == null || gradeList.size() == 0) {
            //没有成绩信息
            return this.findHottestCourse(10);
        }

        //存在成绩信息
        List<CourseVO> courseVOList = new ArrayList<>();
        int cnt = 0;
        for (Grade grade : gradeList) {
            if (cnt == 7) {
                break;
            }
            if (!commentService.isCommented(grade.getCourseCode(), user.getId())) {
                courseVOList.add(getCourseVO(grade.getCourseCode()));
                cnt++;
            }
        }

        return courseVOList;
    }

    /**
     * 热门课程
     *
     * @param num 数量
     * @return
     */
    public List<CourseVO> findHottestCourse(int num) {
        List<String> stringList = commentService.findHottest(num);
        List<CourseVO> courseVOList = new ArrayList<>();
        for (String courseCode : stringList) {
            courseVOList.add(getCourseVO(courseCode));
        }
        return courseVOList;
    }

    public List<CourseVO> getUserCollectionCourseList(String token) {
        Integer userIdByOpenId = userService.getUserIdByToken(token);
        List<CollectionInfo> userCollectionList = collectionInfoService.getUserCollectionList(userIdByOpenId, 0);
        List<CourseVO> courseVOList = new ArrayList<>();
        for (CollectionInfo collectionInfo : userCollectionList) {
            String courseCode = collectionInfo.getOwnerId();
            CourseVO courseVO = getCourseVO(courseCode);

            courseVOList.add(courseVO);

        }
        return courseVOList;
    }

    /**
     * 得到详细课程
     * 课程信息 平均分 教师信息 评论信息 文件数 是否收藏 收藏数
     *
     * @param courseCode
     * @param token
     * @return
     */
    @Override
    public CourseVO getDetailCourseVO(String courseCode, String token) {
        List<CommentVO> commentVOList = commentService.getCommentVO(courseCode, token);
        Course course = findBy("courseCode", courseCode);
        int averageRate = commentService.getAverageRate(courseCode);
        List<TeacherInfoDTO> teacherInfoByCourseCode = gradeService.findTeacherInfoByCourseCode(courseCode);
        int fileCount = fileInfoService.getFileCount(courseCode);
        int collectionCount = collectionInfoService.getCollectionCount(courseCode, 0);
        boolean isCollected = collectionInfoService.isExist(courseCode, token, 0);
        return new CourseVO(course, averageRate, teacherInfoByCourseCode, commentVOList, fileCount, isCollected, collectionCount);
    }

    /**
     * 得到简单课程VO 课程 平均分 评论数
     *
     * @param courseCode 课程代码
     * @return
     */
    public CourseVO getCourseVO(String courseCode) {
        Course course = findBy("courseCode", courseCode);
        int averageRate = commentService.getAverageRate(courseCode);
        int count = commentService.getCount(courseCode);
        int collectionCount = collectionInfoService.getCollectionCount(courseCode, 0);
        int fileCount = fileInfoService.getFileCount(courseCode);

        return new CourseVO(course, averageRate, count, fileCount, collectionCount);
    }
}
