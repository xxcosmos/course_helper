package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.CourseInfo;
import me.xiaoyuu.course_helper.service.CourseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/10.
 */
@RestController
@RequestMapping("/course/info")
public class CourseInfoController {
    @Resource
    private CourseInfoService courseInfoService;

    @PostMapping
    public Result add(@RequestBody CourseInfo courseInfo) {
        courseInfoService.save(courseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        courseInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody CourseInfo courseInfo) {
        courseInfoService.update(courseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        CourseInfo courseInfo = courseInfoService.findById(id);
        return ResultGenerator.genSuccessResult(courseInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CourseInfo> list = courseInfoService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
