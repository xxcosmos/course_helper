package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.model.Course;
import me.xiaoyuu.course_helper.core.service.Service;
import me.xiaoyuu.course_helper.vo.CommentVO;
import me.xiaoyuu.course_helper.vo.CourseVO;

import java.util.List;


/**
 * Created by xiaoyuu on 2019/05/11.
 */
public interface CourseService extends Service<Course> {

    int saveWithIgnore(Course course);

    List<CourseVO> findHottestCourse(int num);

    List<CourseVO> selectByCollegeCode(String collegeCode);

    List<CourseVO> getRecommendCourse(String openid);

    List<CourseVO> findCourseListByKeyword(String keyword);

    CourseVO getCourseVO(String courseCode);

    CourseVO getDetailCourseVO(String courseCode, String token);

    List<CourseVO> getUserCollectionCourseList(String token);
}
