package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.GradeInfo;
import me.xiaoyuu.course_helper.service.GradeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/08.
 */
@RestController
@RequestMapping("/grade/info")
public class GradeInfoController {
    @Resource
    private GradeInfoService gradeInfoService;

    @PostMapping
    public Result add(@RequestBody GradeInfo gradeInfo) {
        gradeInfoService.save(gradeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        gradeInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody GradeInfo gradeInfo) {
        gradeInfoService.update(gradeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        GradeInfo gradeInfo = gradeInfoService.findById(id);
        return ResultGenerator.genSuccessResult(gradeInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GradeInfo> list = gradeInfoService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
