package com.ecs.controller;

import com.ecs.mapper.UserMapper;
import com.ecs.model.Device;
import com.ecs.model.Request.DeviceRegisterRequest;
import com.ecs.model.Response.HttpResponseContent;
import com.ecs.model.Response.ResponseEnum;
import com.ecs.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/devices")
@EnableAutoConfiguration
@Api(tags = "Device", description = "设备相关的操作")
public class DeviceController {

    private final DeviceService deviceService;
    private final UserMapper userMapper;

    @Autowired
    public DeviceController(DeviceService deviceService, UserMapper userMapper) {
        this.deviceService = deviceService;
        this.userMapper = userMapper;
    }

    @ApiOperation(value = "获取设备信息")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public HttpResponseContent getByDeviceNo(@RequestParam("deviceNo") String deviceNo) {
        HttpResponseContent response = new HttpResponseContent();
        Device device = deviceService.getByDeviceNo(deviceNo);
        if(device == null) {
            response.setCode(ResponseEnum.DEVICE_NOT_EXIST.getCode());
            response.setMessage(ResponseEnum.DEVICE_NOT_EXIST.getMessage());
        } else {
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
            response.setData(device);
        }
        return response;
    }

    @ApiOperation(value = "注册新设备")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public HttpResponseContent createDevice(@RequestBody DeviceRegisterRequest deviceRegisterRequest) {
        HttpResponseContent response = new HttpResponseContent();
        Integer num = deviceService.createDevice(deviceRegisterRequest);
        if(!num.equals(1)) {
            response.setCode(ResponseEnum.DEVICE_REGISTER_FAIL.getCode());
            response.setMessage(ResponseEnum.DEVICE_REGISTER_FAIL.getMessage());
        } else {
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
            Device device = deviceService.getByDeviceNo(deviceRegisterRequest.getDeviceNo());
            device.setUserName(deviceRegisterRequest.getUserName());
            response.setData(device);
        }
        return response;
    }

    @ApiOperation(value = "设备登入")
    @RequestMapping(path = "/login", method = RequestMethod.PUT)
    public HttpResponseContent deviceLogin(@RequestParam("id") String id) {
        HttpResponseContent response = new HttpResponseContent();
        deviceService.deviceLogin(id);
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        Device device = deviceService.getByDeviceId(id);
        device.setUserName(userMapper.getUserNameByUid(device.getUid()));
        response.setData(device);
        return response;
    }

    @ApiOperation(value = "设备登出")
    @RequestMapping(path = "/logout", method = RequestMethod.PUT)
    public HttpResponseContent deviceLogout(@RequestParam("id") String id) {
        HttpResponseContent response = new HttpResponseContent();
        deviceService.deviceLogout(id);
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        Device device = deviceService.getByDeviceId(id);
        device.setUserName(userMapper.getUserNameByUid(device.getUid()));
        response.setData(device);
        return response;
    }

    @ApiOperation(value = "设备注销")
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public HttpResponseContent deleteDevice(@RequestParam("deviceNo") String deviceNo) {
        HttpResponseContent response = new HttpResponseContent();
        deviceService.deleteDevice(deviceNo);
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        return response;
    }
}
