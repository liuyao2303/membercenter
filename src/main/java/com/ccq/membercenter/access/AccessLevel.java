package com.ccq.membercenter.access;

/**
 * 访问等级控制
 */
public enum  AccessLevel {

    DEFAULT_LEVEL(1,"默认权限");

    private int level;
    private String msg;

    private AccessLevel(int level,String msg) {
        this.level = level;
        this.msg = msg;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }
}
