package me.xiaoyuu.course_helper.util;

import me.xiaoyuu.course_helper.CourseHelperApplicationTests;
import me.xiaoyuu.course_helper.service.RawCourseInfoService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

public class SOAPUtilTest extends CourseHelperApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Resource
    RawCourseInfoService rawCourseInfoService;


    @Test
    public void test2() {

    }


}