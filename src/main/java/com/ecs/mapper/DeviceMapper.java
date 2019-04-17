package com.ecs.mapper;

import com.ecs.model.Device;
import org.apache.ibatis.annotations.*;

public interface DeviceMapper {

    @Select("SELECT * FROM device WHERE id=#{id};")
    Device getByDeviceId(@Param("id") String id);

    @Select("SELECT * FROM device WHERE device_no=#{deviceNo};")
    Device getByDeviceNo(@Param("deviceNo") String deviceNo);

    @Insert("INSERT INTO device(device_no,device_status,uid,device_type) VALUES(#{deviceNo},#{deviceStatus},#{uid},#{deviceType});")
    Integer createDevice(Device device);

    @Delete("DELETE FROM device WHERE device_no=#{deviceNo};")
    void deleteByDeviceNo(@Param("deviceNo") String deviceNo);

    @Update("UPDATE device SET device_status=#{deviceStatus} WHERE id=#{id};")
    Integer updateDeviceStatusById(@Param("deviceStatus") boolean deviceStatus, @Param("id") String id);

}
