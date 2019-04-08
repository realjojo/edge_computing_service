package com.ecs.controller;

import com.ecs.model.Device;
import com.ecs.model.Response.HttpResponseContent;
import com.ecs.model.Response.ResponseMessage;
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

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @ApiOperation(value = "获取设备信息")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Device getByDeviceNo(@RequestParam("device_no") String deviceNo) {
        return deviceService.getByDeviceNo(deviceNo);
    }

    @ApiOperation(value = "注册新设备")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public Device createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }

    @ApiOperation(value = "设备登入")
    @RequestMapping(path = "/login/{device_id}", method = RequestMethod.PUT)
    public Device deviceLogin(@PathVariable("device_id") String id) {
        return deviceService.deviceLogin(id);
    }

    @ApiOperation(value = "设备登出")
    @RequestMapping(path = "/logout/{device_id}", method = RequestMethod.PUT)
    public Device deviceLogout(@PathVariable("device_id") String id) {
        return deviceService.deviceLogout(id);
    }

    @ApiOperation(value = "设备注销")
    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public HttpResponseContent deleteDevice(@RequestParam("device_no") String deviceNo) {
        HttpResponseContent response = new HttpResponseContent();
        deviceService.deleteDevice(deviceNo);
        response.setResponseCode(200);
        response.setContent(ResponseMessage.SUCCESS);
        return response;
    }
}
