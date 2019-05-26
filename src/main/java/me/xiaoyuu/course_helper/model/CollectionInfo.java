package me.xiaoyuu.course_helper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "collection_info")
public class CollectionInfo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 被收藏的id
     */
    @Column(name = "owner_id")
    private String ownerId;

    /**
     * 收藏者id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 收藏类型 0课程 1 文件
     */
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public CollectionInfo(String ownerId, Integer userId, Integer type) {
        this.ownerId = ownerId;
        this.userId = userId;
        this.type = type;
    }

    public CollectionInfo(String ownerId, Integer type) {
        this.ownerId = ownerId;
        this.type = type;
    }

    public CollectionInfo() {
    }

    @Override
    public String toString() {
        return "CollectionInfo{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", userId=" + userId +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取被收藏的id
     *
     * @return owner_id - 被收藏的id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * 设置被收藏的id
     *
     * @param ownerId 被收藏的id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取收藏者id
     *
     * @return user_id - 收藏者id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置收藏者id
     *
     * @param userId 收藏者id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取收藏类型 0课程 1 文件
     *
     * @return type - 收藏类型 0课程 1 文件
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置收藏类型 0课程 1 文件
     *
     * @param type 收藏类型 0课程 1 文件
     */
    public void setType(Integer type) {
        this.type = type;
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
}