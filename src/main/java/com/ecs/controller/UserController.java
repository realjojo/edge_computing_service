package com.ecs.controller;

import com.ecs.model.User;
import com.ecs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@Api(tags = "User", description = "用户相关的操作")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public User getById(@RequestParam("id") String id) {
        return userService.getById(id);
    }
}
