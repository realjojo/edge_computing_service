package com.ecs.model.Request;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/13 17:26
 */
public class DeviceRegisterRequest {

    private String deviceType;
    private String deviceNo;
    private String userName;
    private boolean deviceStatus;

    public DeviceRegisterRequest(String deviceType, String userName, String deviceNo, boolean deviceStatus) {
        this.deviceType = deviceType;
        this.userName = userName;
        this.deviceNo = deviceNo;
        this.deviceStatus = deviceStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public boolean isDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(boolean deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
}
