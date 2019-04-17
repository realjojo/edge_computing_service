package com.ecs.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Zhaoone on 2019/4/2
 **/
public class PrisonerPhysiologicalData {
    @ApiModelProperty(value = "犯人Id")
    private String prisoner_id;

    @ApiModelProperty(value = "犯人每分钟心跳")
    private String prioner_heatbeat_permin;



    @ApiModelProperty(value = "当前时间")
    private String current_time;

    public String getPrisoner_id() {
        return prisoner_id;
    }

    public void setPrisoner_id(String prisoner_id) {
        this.prisoner_id = prisoner_id;
    }

    public void setPrioner_heatbeat_permin(String prioner_heatbeat_permin) {
        this.prioner_heatbeat_permin = prioner_heatbeat_permin;
    }

    public String getPrioner_heatbeat_permin() {
        return prioner_heatbeat_permin;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public String getCurrent_time() {
        return current_time;
    }
}
