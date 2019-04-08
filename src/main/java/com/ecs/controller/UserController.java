package com.ecs.controller;

import com.ecs.model.Response.HttpResponseContent;
import com.ecs.model.Request.LoginRequest;
import com.ecs.model.Response.ResponseMessage;
import com.ecs.model.User;
import com.ecs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@EnableAutoConfiguration
@Api(tags = "User", description = "用户相关的操作")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public User getById(@RequestParam("id") String id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "用户登陆")
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public User userLogin(@RequestBody LoginRequest loginRequest) throws Exception {
        return userService.userLogin(loginRequest);
    }

    @ApiOperation(value = "用户注销登录")
    @RequestMapping(path = "/logout", method = RequestMethod.DELETE)
    public HttpResponseContent userLogout(@RequestParam(value = "token", defaultValue = "noToken") String token) throws Exception {
        HttpResponseContent response = new HttpResponseContent();
        userService.userLogout(token);
        response.setResponseCode(200);
        response.setContent(ResponseMessage.SUCCESS);
        return response;
    }

    @ApiOperation(value = "新用户注册")
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
