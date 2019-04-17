package com.ecs.mapper;

import com.ecs.model.PrisonerPhysiologicalData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Zhaoone on 2019/4/16
 **/
@Mapper
public interface PrisonerPhysiologicalDataMapper {
//1根据id存入时间、心跳数
//2根据id列出所有心跳数->应该直接由python读取进行算法
    @Insert(" INSERT INTO user_phydata_table( id, current_time, prioner_heatbeat_permin)"+
            " VALUES(#{id},#{current_time},#{prioner_heatbeat_permin}")
    void insertNewPhysiologicalDataMapper(PrisonerPhysiologicalData prisonerPhysiologicalData);
}
