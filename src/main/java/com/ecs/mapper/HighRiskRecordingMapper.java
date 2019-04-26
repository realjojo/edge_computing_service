package com.ecs.mapper;

import com.ecs.model.HighRiskRecording;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/4/24 15:32
 */
public interface HighRiskRecordingMapper {

    @Select("SELECT * FROM high_risk_recording WHERE create_at BETWEEN #{startTime} AND #{endTime};")
    List<HighRiskRecording> getByStartAndEndTime(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);

}
