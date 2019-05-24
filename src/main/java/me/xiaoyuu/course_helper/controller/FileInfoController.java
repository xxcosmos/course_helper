package me.xiaoyuu.course_helper.controller;

import cn.hutool.core.util.IdUtil;
import me.xiaoyuu.course_helper.annotation.IgnoreAuth;
import me.xiaoyuu.course_helper.config.JwtConfig;
import me.xiaoyuu.course_helper.core.result.Result;
import me.xiaoyuu.course_helper.core.result.ResultGenerator;
import me.xiaoyuu.course_helper.model.FileInfo;
import me.xiaoyuu.course_helper.service.FileInfoService;
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
 * Created by xiaoyuu on 2019/05/24.
 */
@RestController
@RequestMapping("/file")
public class FileInfoController {
    private final Logger logger = LoggerFactory.getLogger(FileInfoController.class);

    @Resource
    private FileInfoService fileInfoService;
    @Resource
    private UserService userService;
    @Resource
    private JwtConfig jwtConfig;

    @PostMapping
    public Result add(@RequestBody FileInfo fileInfo, @RequestHeader String authorization) {
        logger.info(fileInfo.toString());
        if (!fileInfoService.checkFileInfo(fileInfo)) {
            return ResultGenerator.genFailResult("缺少参数");
        }
        String openId = jwtConfig.getOpenIdByToken(authorization);
        int userId = userService.findBy("openid", openId).getId();
        fileInfo = fileInfoService.completeFileInfo(fileInfo, userId);
        logger.info(fileInfo.toString());
        fileInfoService.save(fileInfo);
        return ResultGenerator.genSuccessResult(fileInfo.getCosName());


    }

    @GetMapping("/download/count/{id}")
    public Result addDownloadCount(@PathVariable("id") int id) {
        logger.info(String.valueOf(id));
        fileInfoService.addDownloadCount(id);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        fileInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody FileInfo fileInfo) {
        fileInfoService.update(fileInfo);
        return ResultGenerator.genSuccessResult();
    }

    @IgnoreAuth
    @GetMapping("/course/file/{ownerId}")
    public Result getFileList(@PathVariable String ownerId) {
        logger.info(ownerId);
        List<FileInfo> fileInfoList = fileInfoService.findByOwnerIdAndType(ownerId, "file");
        logger.info(fileInfoList.toString());
        return ResultGenerator.genSuccessResult(fileInfoList);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<FileInfo> list = fileInfoService.findAll();
        PageInfo pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
