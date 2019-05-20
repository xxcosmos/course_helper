package me.xiaoyuu.course_helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CourseHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseHelperApplication.class, args);
    }

}
