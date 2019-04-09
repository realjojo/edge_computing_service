package com.ecs.controller;

import com.ecs.server.WebSocketServer;
import com.ecs.model.Device;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "DeviceMonitor", description = "设备信息监控")
public class WebSocketController {
    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping(value = "/pushDeviceToWeb",method = RequestMethod.POST,consumes = "application/json")
    public Device pushDeviceToWeb(@RequestBody Device Device){
        return Device;
    }
}
