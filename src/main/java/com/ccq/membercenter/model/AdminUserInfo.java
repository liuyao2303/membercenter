package com.ccq.membercenter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "admin_user_tbl")
public class AdminUserInfo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",length = 64)
    private String username;

    @Column(name = "avatar",length = 128)
    private String avatar;

    @Column(name = "sex", precision = 1)
    private Integer sex;

    @Column(name = "phone_number",length = 11)
    private String phone;

    @Column(name = "email",length = 64)
    private String email;

    @Column(name = "address",length = 128)
    private String addr;

    @Column(name = "city_code",length = 4)
    private String city;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "status",precision = 1)
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminUserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
