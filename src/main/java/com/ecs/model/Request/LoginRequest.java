package com.ecs.model.Request;

/**
 * @Author: jojo
 * @Description: 用户登陆请求格式
 * @Date: Created on 2019/4/4 21:55
 */
public class LoginRequest {

    private String userName;
    private String password;

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
}
