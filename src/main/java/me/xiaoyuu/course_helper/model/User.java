package me.xiaoyuu.course_helper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class User {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 微信openid
     */
    private String openid;

    @Column(name = "session_key")
    private String sessionKey;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 性别：0未知，1男，2女
     */
    private Integer gender;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    @Column(name = "student_id")
    private String studentId;

    /**
     * 0正常，1，已认证，-1 删除
     */
    private Integer state;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取微信openid
     *
     * @return openid - 微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信openid
     *
     * @param openid 微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return session_key
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取用户头像
     *
     * @return avatar_url - 用户头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置用户头像
     *
     * @param avatarUrl 用户头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取性别：0未知，1男，2女
     *
     * @return gender - 性别：0未知，1男，2女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别：0未知，1男，2女
     *
     * @param gender 性别：0未知，1男，2女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return student_id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取0正常，1，已认证，-1 删除
     *
     * @return state - 0正常，1，已认证，-1 删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0正常，1，已认证，-1 删除
     *
     * @param state 0正常，1，已认证，-1 删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}