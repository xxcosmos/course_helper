package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.util.CosUtil;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/cos_sign/{key}")
    public Result getACosSign(@PathVariable String key) {
        String sign = CosUtil.GetAPostUploadSign(key);
        return ResultGenerator.genSuccessResult(sign);
    }
}
