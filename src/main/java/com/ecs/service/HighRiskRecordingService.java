package com.ecs.service;

import com.ecs.mapper.HighRiskRecordingMapper;
import com.ecs.model.HighRiskRecording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/24 15:41
 */
@Service
public class HighRiskRecordingService {

    private final HighRiskRecordingMapper highRiskRecordingMapper;

    @Autowired
    public HighRiskRecordingService(HighRiskRecordingMapper highRiskRecordingMapper) {
        this.highRiskRecordingMapper = highRiskRecordingMapper;
    }

    public List<HighRiskRecording> getByStartAndEndTime(Timestamp startTime, Timestamp endTime) {
        // TODO: 获取异常风险数据
        return highRiskRecordingMapper.getByStartAndEndTime(startTime, endTime);
    }

}
