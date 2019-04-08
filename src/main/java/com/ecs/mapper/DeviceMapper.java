package com.ecs.mapper;

import com.ecs.model.Device;
import org.apache.ibatis.annotations.*;

public interface DeviceMapper {

    @Select("SELECT * FROM device WHERE device_no=#{deviceNo};")
    Device getByDeviceNo(@Param("device_no") String deviceNo);

    @Insert("INSERT INTO device(device_no,device_status) VALUES(#{deviceNo},#{deviceStatus});")
    Device createDevice(Device device);

    @Delete("DELETE FROM device WHERE device_no=#{deviceNo};")
    void deleteByDeviceNo(@Param("device_no") String deviceNo);

    @Update("UPDATE device SET device_status=#{deviceStatus} WHERE id=#{id};")
    Device updateDeviceStatusById(@Param("device_status") boolean deviceStatus, @Param("id") String id);

}
