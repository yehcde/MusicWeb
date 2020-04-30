package com.yhc.music.bean;

/**
 * @author yehaocheng
 */
public class Video {
    private long id;
    private String type;
    private String path;
    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
