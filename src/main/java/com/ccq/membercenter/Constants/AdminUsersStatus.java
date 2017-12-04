package com.ccq.membercenter.Constants;

public enum AdminUsersStatus {
    NEW(1,"新增"),STATUS_OK(2,"用户状态正长"),STATUS_LOCKED(4,"用户锁定"),STATUS_DELETE(3,"用户已删除");

    private int type;
    private String msg;
    private AdminUsersStatus(int code, String msg) {
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
