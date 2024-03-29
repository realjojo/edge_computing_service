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

import java.util.List;

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

    @ApiOperation(value = "获取所有设备信息")
    @RequestMapping(path = "/get_all", method = RequestMethod.GET)
    public List<Device> getAll() {
        return deviceService.getAll();
    }

    @ApiOperation(value = "注册新设备")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public HttpResponseContent createDevice(@RequestParam("deviceType") String deviceType, @RequestParam("deviceNo") String deviceNo, @RequestParam("userName") String userName, @RequestParam("deviceStatus") String deviceStatus) {
        HttpResponseContent response = new HttpResponseContent();
        boolean ds;
        if(deviceStatus.equals("true")) {
            ds = true;
        } else {
            ds = false;
        }
        DeviceRegisterRequest deviceRegisterRequest = new DeviceRegisterRequest(deviceType, userName, deviceNo, ds);
        Device device = deviceService.createDevice(deviceRegisterRequest);
        if(device == null) {
            response.setCode(ResponseEnum.DEVICE_REGISTER_FAIL.getCode());
            response.setMessage(ResponseEnum.DEVICE_REGISTER_FAIL.getMessage());
        } else {
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
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
        response.setData(deviceService.getByDeviceId(id));
        return response;
    }

    @ApiOperation(value = "设备登出")
    @RequestMapping(path = "/logout", method = RequestMethod.PUT)
    public HttpResponseContent deviceLogout(@RequestParam("id") String id) {
        HttpResponseContent response = new HttpResponseContent();
        deviceService.deviceLogout(id);
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setData(deviceService.getByDeviceId(id));
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
