package com.ecs.model.Request;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/13 17:26
 */
public class DeviceRegisterRequest {

    private String deviceType;

    private String userName;

    private String deviceNo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }
}
