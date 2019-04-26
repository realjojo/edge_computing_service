package com.ecs.controller;

import com.ecs.model.HighRiskRecording;
import com.ecs.service.HighRiskRecordingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/24 15:44
 */
@RestController
@RequestMapping("/high_risk_recordings")
@Api(tags = "HighRiskRecording", description = "获取历史异常风险记录")
public class HighRiskRecordingController {

    private final HighRiskRecordingService highRiskRecordingService;

    @Autowired
    public HighRiskRecordingController(HighRiskRecordingService highRiskRecordingService) {
        this.highRiskRecordingService = highRiskRecordingService;
    }

    @ApiOperation(value = "获取某段时间内的异常风险数据")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public List<HighRiskRecording> getByStartAndEndTime(@RequestParam("startTime") Timestamp startTime, @RequestParam("endTime") Timestamp endTime) {
        return highRiskRecordingService.getByStartAndEndTime(startTime, endTime);
    }

}
