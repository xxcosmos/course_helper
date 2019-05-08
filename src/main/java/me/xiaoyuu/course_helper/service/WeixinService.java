package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.core.service.Service;
import me.xiaoyuu.course_helper.dto.WeixinAuthDTO;
import me.xiaoyuu.course_helper.dto.WeixinUserInfoDTO;
import me.xiaoyuu.course_helper.model.User;

public interface WeixinService {
    WeixinAuthDTO getWeixinAuthDTO(String code);

    User getUser(WeixinAuthDTO weixinAuthDTO, WeixinUserInfoDTO weixinUserInfoDTO);
}
