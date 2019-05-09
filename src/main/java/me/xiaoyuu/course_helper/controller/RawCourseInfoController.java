package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.RawCourseInfo;
import me.xiaoyuu.course_helper.service.RawCourseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/08.
 */
@RestController
@RequestMapping("/raw/course/info")
public class RawCourseInfoController {
    @Resource
    private RawCourseInfoService rawCourseInfoService;

    @PostMapping
    public Result add(@RequestBody RawCourseInfo rawCourseInfo) {
        rawCourseInfoService.save(rawCourseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        rawCourseInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody RawCourseInfo rawCourseInfo) {
        rawCourseInfoService.update(rawCourseInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        RawCourseInfo rawCourseInfo = rawCourseInfoService.findById(id);
        return ResultGenerator.genSuccessResult(rawCourseInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<RawCourseInfo> list = rawCourseInfoService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
