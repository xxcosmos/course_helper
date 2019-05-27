package me.xiaoyuu.course_helper.controller;

import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.CollectionInfo;
import me.xiaoyuu.course_helper.service.CollectionInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.xiaoyuu.course_helper.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyuu on 2019/05/26.
 */
@RestController
@RequestMapping("/collection")
public class CollectionInfoController {
    private final Logger logger = LoggerFactory.getLogger(CollectionInfoController.class);

    @Resource
    private CollectionInfoService collectionInfoService;
    @Resource
    private UserService userService;

    @PostMapping
    public Result add(@RequestBody CollectionInfo collectionInfo, @RequestHeader String authorization) {
        logger.info(authorization);
        if (StringUtils.isBlank(collectionInfo.getOwnerId()) || collectionInfo.getType() == null) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        String ownerId = collectionInfo.getOwnerId();
        int type = collectionInfo.getType();
        boolean exist = collectionInfoService.isExist(ownerId, authorization, type);
        if (exist) {
            CollectionInfo collectionInfo1 = collectionInfoService.getCollectionInfo(ownerId, authorization, type);
            collectionInfoService.deleteById(collectionInfo1.getId());
            return ResultGenerator.genSuccessResult(0);
        } else {
            collectionInfo.setUserId(userService.getUserIdByToken(authorization));
            collectionInfoService.save(collectionInfo);
            return ResultGenerator.genSuccessResult(1);
        }


    }


}
