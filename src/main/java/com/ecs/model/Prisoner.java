package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/6 21:06
 */
public class Prisoner {

    @ApiModelProperty(value = "犯人id")
    private String id;

    @ApiModelProperty(value = "犯人真实姓名")
    private String prisonerName;

    @ApiModelProperty(value = "押解人员姓名")
    private String userName;

    @ApiModelProperty(value = "记录创建时间")
    private Timestamp createAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrisonerName() {
        return prisonerName;
    }

    public void setPrisonerName(String prisonerName) {
        this.prisonerName = prisonerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Prisoner{" + "id=" + id + ", prisonerName=" + prisonerName + ", userName=" + userName + "}";
    }

}
