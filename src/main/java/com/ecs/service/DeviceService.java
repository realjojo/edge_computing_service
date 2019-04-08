package com.ecs.service;

import com.ecs.mapper.DeviceMapper;
import com.ecs.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceMapper deviceMapper;

    @Autowired
    public DeviceService(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }

    public Device getByDeviceNo(String deviceNo) {
        return deviceMapper.getByDeviceNo(deviceNo);
    }

    public Device createDevice(Device device) {
        return deviceMapper.createDevice(device);
    }

    public Device deviceLogin(String id) {
        return deviceMapper.updateDeviceStatusById(true, id);
    }

    public Device deviceLogout(String id) {
        return deviceMapper.updateDeviceStatusById(false, id);
    }

    public void deleteDevice(String deviceNo) {
        deviceMapper.deleteByDeviceNo(deviceNo);
    }
}
