package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Zhaoone on 2019/4/2
 **/
public class PrisonerGps {

    @ApiModelProperty(value = "当前时间")
    private String current_time;

    @ApiModelProperty(value = "犯人经度")
    private String longitude;

    @ApiModelProperty(value = "犯人纬度")
    private  String latitude;

    @ApiModelProperty(value = "犯人高度")
    private  String height;

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getHeight() {
        return height;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
