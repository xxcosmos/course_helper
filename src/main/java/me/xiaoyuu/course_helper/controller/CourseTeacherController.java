package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.CourseTeacher;
import me.xiaoyuu.course_helper.service.CourseTeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/11.
 */
@RestController
@RequestMapping("/course/teacher")
public class CourseTeacherController {
    @Resource
    private CourseTeacherService courseTeacherService;

    @PostMapping
    public Result add(@RequestBody CourseTeacher courseTeacher) {
        courseTeacherService.save(courseTeacher);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        courseTeacherService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody CourseTeacher courseTeacher) {
        courseTeacherService.update(courseTeacher);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CourseTeacher courseTeacher = courseTeacherService.findById(id);
        return ResultGenerator.genSuccessResult(courseTeacher);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseTeacher> list = courseTeacherService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
