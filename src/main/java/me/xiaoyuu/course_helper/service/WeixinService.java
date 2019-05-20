package me.xiaoyuu.course_helper.service;

import me.xiaoyuu.course_helper.dto.WeixinAuthDTO;
import me.xiaoyuu.course_helper.dto.UserInfo;
import me.xiaoyuu.course_helper.model.User;

public interface WeixinService {
    WeixinAuthDTO getWeixinAuthDTO(String code);

    User getUser(WeixinAuthDTO weixinAuthDTO, UserInfo weixinUserInfoDTO);
}
