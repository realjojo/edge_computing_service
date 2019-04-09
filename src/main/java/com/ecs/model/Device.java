package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

public class Device {

    @ApiModelProperty(value = "设备id")
    private String id;

    @ApiModelProperty(value = "设备编号")
    private String deviceNo;

    @ApiModelProperty(value = "设备连接状态")
    private boolean deviceStatus;

    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    @ApiModelProperty(value = "所属用户")
    private String uid;

    @ApiModelProperty(value = "cpu资源利用率")
    private double cpuUsageRate;

    @ApiModelProperty(value = "内存资源利用率")
    private double memoryUsageRate;

    @ApiModelProperty(value = "剩余电量百分比")
    private double dumpEnergyRate;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getCpuUsageRate() {
        return cpuUsageRate;
    }

    public void setCpuUsageRate(double cpuUsageRate) {
        this.cpuUsageRate = cpuUsageRate;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public double getDumpEnergyRate() {
        return dumpEnergyRate;
    }

    public void setDumpEnergyRate(double dumpEnergyRate) {
        this.dumpEnergyRate = dumpEnergyRate;
    }

    public double getMemoryUsageRate() {
        return memoryUsageRate;
    }

    public void setMemoryUsageRate(double memoryUsageRate) {
        this.memoryUsageRate = memoryUsageRate;
    }

    @Override
    public String toString() {
        return "Device{" + "device_no=" + deviceNo + ", deviceStatus=" + deviceStatus + "}";
    }
}
