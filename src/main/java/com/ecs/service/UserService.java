package com.ecs.service;

import com.ecs.mapper.UserMapper;
import com.ecs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getById(String id) {
        return userMapper.getById(id);
    }
}
