package com.ccq.membercenter.token;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 用户令牌，登录的凭据
 */
public class Token implements Serializable{

    /**
     *  uuid
     */
    private String uuid;

    /* 访问等级 */
    private int accessLevel;

    // 登录时间
    private long loginTime;

    //用户名
    private String username;

    //用户id
    private long userId;

    //用户种类， 管理员用户，平台哟高呼
    private long userCate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserCate() {
        return userCate;
    }

    public void setUserCate(long userCate) {
        this.userCate = userCate;
    }

    /**
     * generate fresh uuid
     * @return
     */
    public static Token getDefaultAdminToken() {
        Token token = new Token();
        token.setLoginTime(new Date().getTime());
        token.setUuid(UUID.randomUUID().toString());
        return token;
    }
}
