package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.ChFeedback;
import me.xiaoyuu.course_helper.service.ChFeedbackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/26.
 */
@RestController
@RequestMapping("/feedback")
public class ChFeedbackController {
    @Resource
    private ChFeedbackService chFeedbackService;

    @IgnoreAuth
    @PostMapping
    public Result add(@RequestBody ChFeedback chFeedback) {
        chFeedbackService.save(chFeedback);
        return ResultGenerator.genSuccessResult();
    }

}
