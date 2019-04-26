package com.ecs.service;

import com.ecs.mapper.DeviceMapper;
import com.ecs.mapper.UserMapper;
import com.ecs.model.Device;
import com.ecs.model.Request.DeviceRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        Device device = deviceMapper.getByDeviceId(id);
        device.setUserName(userMapper.getUserNameByUid(device.getUid()));
        return device;
    }

    public Device getByDeviceNo(String deviceNo) {
        Device device = deviceMapper.getByDeviceNo(deviceNo);
        device.setUserName(userMapper.getUserNameByUid(device.getUid()));
        return device;
    }

    public List<Device> getAll() {
        return deviceMapper.getAll();
    }

    public Device createDevice(DeviceRegisterRequest deviceRegisterRequest) {
        String uid = userMapper.getUidByUserName(deviceRegisterRequest.getUserName());
        String deviceType = deviceRegisterRequest.getDeviceType();
        if(deviceType.equals("phone") || deviceType.equals("pad")) {
            // 一个user只可能有一个phone和一个ipad
            if(deviceMapper.getByUserIdAndType(uid, deviceType) != null) {
                return null;
            } else {
                Device device = new Device();
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                String date = df.format(new Date());
                String deviceNo = deviceRegisterRequest.getDeviceType() + date;
                device.setDeviceNo(deviceNo);
                device.setDeviceType(deviceType);
                device.setDeviceStatus(false);
                device.setUid(uid);
                deviceMapper.createDevice(device);
                return deviceMapper.getByDeviceNo(device.getDeviceNo());
            }
        } else {
            return null;
        }
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
