package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.util.CosUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @RequiresAuthentication
    @GetMapping("/cos_sign/{key}")
    public Result getACosSign(@PathVariable String key) {
        String sign = CosUtil.GetAPostUploadSign(key);
        return ResultGenerator.genSuccessResult(sign);
    }
}
