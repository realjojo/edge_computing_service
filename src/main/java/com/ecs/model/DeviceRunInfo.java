package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/13 18:56
 */
public class DeviceRunInfo {

    @ApiModelProperty(value = "cpu资源利用率")
    private double cpuUsageRate;

    @ApiModelProperty(value = "内存资源利用率")
    private double memoryUsageRate;

    @ApiModelProperty(value = "剩余电量百分比")
    private double dumpEnergyRate;

    public double getCpuUsageRate() {
        return cpuUsageRate;
    }

    public void setCpuUsageRate(double cpuUsageRate) {
        this.cpuUsageRate = cpuUsageRate;
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

}
