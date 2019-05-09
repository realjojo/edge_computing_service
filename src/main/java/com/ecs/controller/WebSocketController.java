package com.ecs.controller;

import com.ecs.server.WebSocketServer;
import com.ecs.model.Device;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "WebSocket", description = "服务端向客户端推送消息")
public class WebSocketController {

    @Resource
    private WebSocketServer webSocketServer;

    @RequestMapping(path = "/many", method = RequestMethod.GET)
    public String helloManyWebSocket(){
        //向所有人发送消息
        webSocketServer.sendMessage("你好~！");

        return "发送成功";
    }
}
