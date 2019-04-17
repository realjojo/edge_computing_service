package com.ecs.service;

import com.ecs.mapper.DeviceMapper;
import com.ecs.mapper.UserMapper;
import com.ecs.model.Device;
import com.ecs.model.Request.DeviceRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceMapper deviceMapper;
    private final UserMapper userMapper;

    @Autowired
    public DeviceService(DeviceMapper deviceMapper, UserMapper userMapper) {
        this.deviceMapper = deviceMapper;
        this.userMapper = userMapper;
    }

    public Device getByDeviceId(String id) {
        return deviceMapper.getByDeviceId(id);
    }

    public Device getByDeviceNo(String deviceNo) {
        return deviceMapper.getByDeviceNo(deviceNo);
    }

    public Integer createDevice(DeviceRegisterRequest deviceRegisterRequest) {
        Device device = new Device();
        device.setDeviceNo(deviceRegisterRequest.getDeviceNo());
        device.setDeviceType(deviceRegisterRequest.getDeviceType());
        device.setDeviceStatus(false);
        device.setUid(userMapper.getUidByUserName(deviceRegisterRequest.getUserName()));
        return deviceMapper.createDevice(device);
    }

    public Integer deviceLogin(String id) {
        return deviceMapper.updateDeviceStatusById(true, id);
    }

    public Integer deviceLogout(String id) {
        return deviceMapper.updateDeviceStatusById(false, id);
    }

    public void deleteDevice(String deviceNo) {
        deviceMapper.deleteByDeviceNo(deviceNo);
    }
}
