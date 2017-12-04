package com.ccq.membercenter.Constants;

public enum Constants {
    ADMIN_USER(1,"管理员用户"),PLATFORM_USER(2,"平台用户");

    private int type;
    private String msg;
    private Constants(int code,String msg) {
        this.type = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getType () {
        return this.type;
    }
}
