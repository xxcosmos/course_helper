package me.xiaoyuu.course_helper.vo;


import me.xiaoyuu.course_helper.model.User;

public class UserVO {
    private int id;
    private String nickname;
    private String avatarUrl;
    private int gender;
    private String studentId;
    private int state;

    public UserVO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.avatarUrl = user.getAvatarUrl();
        this.gender = user.getGender();
        this.studentId = user.getStudentId();
        this.state = user.getState();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
