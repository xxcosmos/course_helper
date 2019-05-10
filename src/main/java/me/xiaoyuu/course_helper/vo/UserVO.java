package me.xiaoyuu.course_helper.vo;

import me.xiaoyuu.course_helper.model.User;

public class UserVO {
    private int id;
    private String nickname;
    private String avatar_url;
    private int gender;
    private int status;

    public UserVO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.avatar_url = user.getAvatarUrl();
        this.gender = user.getGender();
        this.status = user.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
