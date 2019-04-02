package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

public class User {

    @ApiModelProperty(value = "用户id")
    private String id;

    @ApiModelProperty(value = "用户编号")
    private String uid;

    @ApiModelProperty(value = "用户真实姓名")
    private String userName;

    @ApiModelProperty(value = "用户登录密码")
    private String password;

    @ApiModelProperty(value = "注册手机号")
    private String phone;

    @ApiModelProperty(value = "账号创建时间")
    private Timestamp create_at;

    @ApiModelProperty(value = "token生成时间")
    private String token_create_at;

    @ApiModelProperty(value = "登录token")
    private String loginToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public String getToken_create_at() {
        return token_create_at;
    }

    public void setToken_create_at(String token_create_at) {
        this.token_create_at = token_create_at;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", phone=" + phone + "}";
    }
}
