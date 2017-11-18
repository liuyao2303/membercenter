package com.ccq.membercenter.model;

/**
 * 用户信息
 *
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user_information_tbl")
public class UserInfoModel {

    @Id
    private Long id;

    @Column(name = "username",length = 64)
    private String username;

    @Column(name = "avatar",length = 128)
    private String avatar;

    @Column(name = "sex", precision = 1)
    private Integer sex;

    @Column(name = "phone_number",length = 11)
    private String phoneNumber;

    @Column(name = "email",length = 64)
    private String email;

    @Column(name = "address",length = 128)
    private String address;

    @Column(name = "score",precision = 12)
    private Integer score;

    @Column(name = "city_code",length = 4)
    private String cityCode;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "status",precision = 1)
    private int status;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", cityCode='" + cityCode + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
