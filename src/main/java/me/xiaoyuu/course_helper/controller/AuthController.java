package me.xiaoyuu.course_helper.controller;

import com.tencent.cloud.CosStsClient;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.dto.CosCredential;
import me.xiaoyuu.course_helper.util.CosUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.TreeMap;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/cos")
    public Result getTempCredential() {
        CosCredential tempCredential = CosUtil.getTempCredential();
        logger.info(tempCredential.toString());
        return ResultGenerator.genSuccessResult(tempCredential);
    }
}
