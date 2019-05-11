package me.xiaoyuu.course_helper.model;

import java.util.Date;
import javax.persistence.*;

public class Comment {
    /**
     * 评论主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父评论id
     */
    private Integer pid;

    /**
     * 被评论的资源id，可以是人、项目、资源
     */
    @Column(name = "owner_id")
    private Integer ownerId;

    /**
     * 评论类型：对人评论，对商品评论，对说说评论
     */
    private Integer type;

    /**
     * 评论者id
     */
    @Column(name = "from_id")
    private Integer fromId;

    /**
     * 被评论者id
     */
    @Column(name = "to_id")
    private Integer toId;

    /**
     * 点赞的数量
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 评论内容
     */
    private String content;

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

    @Column(name = "child_comment_num")
    private Integer childCommentNum;

    public Integer getChildCommentNum() {
        return childCommentNum;
    }

    public void setChildCommentNum(Integer childCommentNum) {
        this.childCommentNum = childCommentNum;
    }

    /**
     * 获取评论主键id
     *
     * @return id - 评论主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评论主键id
     *
     * @param id 评论主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父评论id
     *
     * @return pid - 父评论id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父评论id
     *
     * @param pid 父评论id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取被评论的资源id，可以是人、项目、资源
     *
     * @return owner_id - 被评论的资源id，可以是人、项目、资源
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * 设置被评论的资源id，可以是人、项目、资源
     *
     * @param ownerId 被评论的资源id，可以是人、项目、资源
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取评论类型：对人评论，对商品评论，对说说评论
     *
     * @return type - 评论类型：对人评论，对商品评论，对说说评论
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置评论类型：对人评论，对商品评论，对说说评论
     *
     * @param type 评论类型：对人评论，对商品评论，对说说评论
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取评论者id
     *
     * @return from_id - 评论者id
     */
    public Integer getFromId() {
        return fromId;
    }

    /**
     * 设置评论者id
     *
     * @param fromId 评论者id
     */
    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    /**
     * 获取被评论者id
     *
     * @return to_id - 被评论者id
     */
    public Integer getToId() {
        return toId;
    }

    /**
     * 设置被评论者id
     *
     * @param toId 被评论者id
     */
    public void setToId(Integer toId) {
        this.toId = toId;
    }

    /**
     * 获取点赞的数量
     *
     * @return like_num - 点赞的数量
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置点赞的数量
     *
     * @param likeNum 点赞的数量
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
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