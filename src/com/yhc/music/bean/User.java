package com.yhc.music.bean;

/**
 * @author 用户
 */
public class User {
    private long id;

    private String username;

    private String password;

    private String phone;

    private String imlUrl;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getImlUrl() {
        return imlUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImlUrl(String imlUrl) {
        this.imlUrl = imlUrl;
    }
}
