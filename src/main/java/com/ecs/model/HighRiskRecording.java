package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/24 15:16
 */
public class HighRiskRecording {

    @ApiModelProperty(value = "记录id")
    private String id;

    @ApiModelProperty(value = "犯人姓名")
    private String prisonerName;

    @ApiModelProperty(value = "风险值")
    private String riskValue;

    @ApiModelProperty(value = "记录创建时间")
    private Timestamp createAt;

    public String getId() {
        return id;
    }

    public String getPrisonerName() {
        return prisonerName;
    }

    public void setPrisonerName(String prisonerName) {
        this.prisonerName = prisonerName;
    }

    public String getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(String riskValue) {
        this.riskValue = riskValue;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return "HighRiskRecording{" + "id=" + id + ", prisonerName=" + prisonerName + ", riskValue=" + riskValue + ", createAt" + createAt + "}";
    }

}
