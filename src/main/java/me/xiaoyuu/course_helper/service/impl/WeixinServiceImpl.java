package me.xiaoyuu.course_helper.service.impl;

import me.xiaoyuu.course_helper.dto.WeixinAuthDTO;
import me.xiaoyuu.course_helper.dto.UserInfo;
import me.xiaoyuu.course_helper.model.User;
import me.xiaoyuu.course_helper.service.WeixinService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class WeixinServiceImpl implements WeixinService {
    @Resource
    RestTemplate restTemplate;
    @Value("${wx.applet.app-id}")
    private String appid;
    @Value("${wx.applet.app-secret}")
    private String appSecret;

    public WeixinAuthDTO getWeixinAuthDTO(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={1}&secret={2}&js_code={3}&grant_type=authorization_code";
        return restTemplate.getForObject(url, WeixinAuthDTO.class, appid, appSecret, code);
    }

    public User getUser(WeixinAuthDTO weixinAuthDTO, UserInfo weixinUserInfoDTO) {
        User user = new User();
        user.setSessionKey(weixinAuthDTO.getSessionKey());
        user.setOpenid(weixinAuthDTO.getOpenid());
        user.setAvatarUrl(weixinUserInfoDTO.getAvatarUrl());
        user.setGender(weixinUserInfoDTO.getGender());
        user.setCity(weixinUserInfoDTO.getCity());
        user.setProvince(weixinUserInfoDTO.getProvince());
        user.setNickname(weixinUserInfoDTO.getNickName());
        return user;
    }
}
