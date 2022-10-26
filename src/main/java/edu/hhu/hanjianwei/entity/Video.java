package edu.hhu.hanjianwei.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/25/2022 - 11:21 AM
 */
@Data
public class Video {
    private int id;
    private String name;
    private String author;
    private String type;
    private LocalDateTime createTime;
    private int timeLength;
    private String videoPath;
    private String coverPath;
    private String description;

    public Video(int id, String name, String author, String type, LocalDateTime createTime, int timeLength, String videoPath, String coverPath, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
        this.createTime = createTime;
        this.timeLength = timeLength;
        this.videoPath = videoPath;
        this.coverPath = coverPath;
        this.description = description;
    }

    public Video() {
    }

    public Video(int id, String name, String author, String type, LocalDateTime createTime, int timeLength, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
        this.createTime = createTime;
        this.timeLength = timeLength;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
