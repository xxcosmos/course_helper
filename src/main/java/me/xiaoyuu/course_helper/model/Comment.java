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
     * 被评论的资源id，可以是人、项目、资源
     */
    @Column(name = "owner_id")
    private String ownerId;


    /**
     * 评论者id
     */
    @Column(name = "from_id")
    private Integer fromId;



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
    private int star;

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
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
     * 获取被评论的资源id，可以是人、项目、资源
     *
     * @return owner_id - 被评论的资源id，可以是人、项目、资源
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * 设置被评论的资源id，可以是人、项目、资源
     *
     * @param ownerId 被评论的资源id，可以是人、项目、资源
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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