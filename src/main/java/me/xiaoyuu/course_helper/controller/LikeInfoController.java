package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.LikeInfo;
import me.xiaoyuu.course_helper.service.LikeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/11.
 */
@RestController
@RequestMapping("/like/info")
public class LikeInfoController {
    @Resource
    private LikeInfoService likeInfoService;

    @PostMapping
    public Result add(@RequestBody LikeInfo likeInfo) {
        if (likeInfo == null || likeInfo.getOwnerId() == null || likeInfo.getUserId() == null) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        likeInfoService.save(likeInfo);

        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        likeInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody LikeInfo likeInfo) {
        likeInfoService.update(likeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        LikeInfo likeInfo = likeInfoService.findById(id);
        return ResultGenerator.genSuccessResult(likeInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<LikeInfo> list = likeInfoService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
