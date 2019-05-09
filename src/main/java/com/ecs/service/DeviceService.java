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
        return deviceMapper.getByDeviceId(id);
    }

    public Device getByDeviceNo(String deviceNo) {
        return deviceMapper.getByDeviceNo(deviceNo);
    }

    public List<Device> getAll() {
        return deviceMapper.getAll();
    }

    public Device createDevice(DeviceRegisterRequest deviceRegisterRequest) {
        if(deviceRegisterRequest.getUserName() == null || deviceRegisterRequest.getDeviceType() == null || deviceRegisterRequest.getDeviceNo() == null) {
            return null;
        } else {
            String uid = userMapper.getUidByUserName(deviceRegisterRequest.getUserName());
            String deviceType = deviceRegisterRequest.getDeviceType();
            String deviceNo = deviceRegisterRequest.getDeviceNo();
            if(deviceType.equals("phone") || deviceType.equals("pad")) {
                // 一个user只可能有一个phone和一个ipad
                if(deviceMapper.getByUserIdAndType(uid, deviceType) != null) {
                    return null;
                } else if(deviceMapper.getByDeviceNo(deviceNo) != null) {
                    return null;
                } else {
                    Device device = new Device();
//                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//                String date = df.format(new Date());
//                String deviceNo = deviceRegisterRequest.getDeviceType() + date;
                    device.setDeviceNo(deviceNo);
                    device.setDeviceType(deviceType);
                    device.setDeviceStatus(deviceRegisterRequest.isDeviceStatus());
                    device.setUid(uid);
                    deviceMapper.createDevice(device);
                    return deviceMapper.getByDeviceNo(deviceNo);
                }
            } else {
                return null;
            }
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
