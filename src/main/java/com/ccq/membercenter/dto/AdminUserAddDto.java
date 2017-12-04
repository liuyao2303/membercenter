package com.ccq.membercenter.dto;

import com.ccq.membercenter.model.AdminUserInfo;
import org.springframework.beans.BeanUtils;

public class AdminUserAddDto {
    private String username;

    private String avatar;

    private Integer sex;

    private String phone;

    private String email;

    private String addr;

    private String city;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static AdminUserinfoDto fromAdminUserModel(AdminUserInfo user) {
        AdminUserinfoDto toUser = new AdminUserinfoDto();
        BeanUtils.copyProperties(user,toUser);
        return toUser;
    }
}
