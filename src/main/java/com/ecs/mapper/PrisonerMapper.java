package com.ecs.mapper;

import com.ecs.model.Prisoner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: jojo
 * @Description:
 * @Date: Created on 2019/5/6 21:16
 */
public interface PrisonerMapper {

    @Select("SELECT * FROM prisoner WHERE id=#{id};")
    Prisoner getById(@Param("id") String id);

    @Select("SELECT * FROM prisoner;")
    List<Prisoner> getAll();

}
