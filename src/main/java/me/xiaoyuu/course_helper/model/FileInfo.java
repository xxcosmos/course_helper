package me.xiaoyuu.course_helper.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "file_info")
public class FileInfo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对象id
     */
    @Column(name = "owner_id")
    private String ownerId;
    /**
     * 上传者id
     */
    @Column(name = "from_id")
    private Integer fromId;
    /**
     * 文件类型
     */
    private String type;
    /**
     * 原始文件名
     */
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_description")
    private String fileDescription;
    private Integer size;
    @Column(name = "cos_name")
    private String cosName;
    /**
     * 下载次数
     */
    @Column(name = "download_count")
    private Integer downloadCount;
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

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", fromId=" + fromId +
                ", type='" + type + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", size=" + size +
                ", cosName='" + cosName + '\'' +
                ", downloadCount=" + downloadCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
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
     * 获取对象id
     *
     * @return owner_id - 对象id
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * 设置对象id
     *
     * @param ownerId 对象id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取上传者id
     *
     * @return from_id - 上传者id
     */
    public Integer getFromId() {
        return fromId;
    }

    /**
     * 设置上传者id
     *
     * @param fromId 上传者id
     */
    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    /**
     * 获取文件类型
     *
     * @return type - 文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置文件类型
     *
     * @param type 文件类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取原始文件名
     *
     * @return file_name - 原始文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置原始文件名
     *
     * @param fileName 原始文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return file_description
     */
    public String getFileDescription() {
        return fileDescription;
    }

    /**
     * @param fileDescription
     */
    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    /**
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return cos_name
     */
    public String getCosName() {
        return cosName;
    }

    /**
     * @param cosName
     */
    public void setCosName(String cosName) {
        this.cosName = cosName;
    }

    /**
     * 获取下载次数
     *
     * @return download_count - 下载次数
     */
    public Integer getDownloadCount() {
        return downloadCount;
    }

    /**
     * 设置下载次数
     *
     * @param downloadCount 下载次数
     */
    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
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