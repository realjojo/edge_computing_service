package com.ecs.model.Request;

/**
 * @Author: jojo
 * @Description: 用户注册请求body格式
 * @Date: Created on 2019/4/11 21:26
 */
public class UserRegisterRequest {

    private String userName;

    private String password;

    private String confirmPassword;

    public UserRegisterRequest(String userName, String password, String confirmPassword) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}
