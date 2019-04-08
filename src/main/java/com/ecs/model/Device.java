package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

public class Device {

    @ApiModelProperty(value = "设备id")
    private String id;

    @ApiModelProperty(value = "设备编号")
    private String deviceNo;

    @ApiModelProperty(value = "设备状态")
    private boolean deviceStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public void setDeviceStatus(boolean deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public boolean isDeviceStatus() {
        return deviceStatus;
    }

    @Override
    public String toString() {
        return "Device{" + "device_no=" + deviceNo + ", deviceStatus=" + deviceStatus + "}";
    }
}
