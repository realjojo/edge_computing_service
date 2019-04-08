package com.ecs.service;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ecs.mapper.UserMapper;
import com.ecs.model.Exception.EdgeComputingServiceException;
import com.ecs.model.Request.LoginRequest;
import com.ecs.model.Response.ResponseMessage;
import com.ecs.model.User;
import com.ecs.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    private static final String mysqlSdfPatternString = "yyyy-MM-dd HH:mm:ss";

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getById(String id) {
        return userMapper.getById(id);
    }

    public User userLogin(LoginRequest loginRequest) throws Exception {
        SimpleDateFormat mysqlSdf = new java.text.SimpleDateFormat(mysqlSdfPatternString);
        User user = userMapper.getByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword());
        if(user == null) {
            throw new EdgeComputingServiceException(403, ResponseMessage.ERROR, ResponseMessage.LOGIN_FAILED);
        } else {
            //采用jwt获得token
            Date createTime = new Date();
            //每七天需要重新登录(可以直接将过期时间写入token，解析token时即可判断是否过期，而无需在代码中判断)
            Date expireTime = new Date(createTime.getTime() + 1000 * 60 * 60 * 24 * 7);
            Map<String, String> content = new HashMap<>();
            content.put("uid", user.getId());
            String token = CommonUtil.createJWT(content, "EdgeComputingService", createTime, expireTime);
            //更新数据库token_create_at，之后每次鉴权需要查看数据库查看自己的token是否是最新的
            userMapper.updateTokenCreateTimeById(mysqlSdf.format(createTime), user.getId());
            //将token返回作为登录凭证
            user.setLoginToken(token);
            user.setPassword(null);
            user.setToken_create_at(null);
            return user;
        }
    }

    public void userLogout(String token) throws Exception {
        String userId = getUserIdFromToken(token);
        userMapper.updateTokenCreateTimeById(null, userId);
    }

    public User createUser(User user) {
        return userMapper.createUser(user);
    }

    public String getUserIdFromToken(String token) throws Exception {
        SimpleDateFormat mysqlSdf = new java.text.SimpleDateFormat(mysqlSdfPatternString);
        if (Objects.equals(token, "noToken"))
            throw new EdgeComputingServiceException(403, ResponseMessage.ERROR, ResponseMessage.DO_NOT_LOGIN);
        Date now = new Date();
        DecodedJWT jwt = CommonUtil.phraseJWT(token, "EdgeComputingService", ResponseMessage.INVALID_USER_TOKEN);
        String userId = JSONObject.parseObject(jwt.getSubject()).getString("uid");
        String tokenCreateTime = userMapper.getTokenCreateTime(userId);
        //数据库中token创建时间字段为空，说明用户已经注销登陆
        if (tokenCreateTime == null)
            throw new EdgeComputingServiceException(403, ResponseMessage.ERROR, ResponseMessage.DO_NOT_LOGIN);
        if (jwt.getIssuedAt().getTime() != mysqlSdf.parse(tokenCreateTime).getTime())
            throw new EdgeComputingServiceException(403, ResponseMessage.ERROR, ResponseMessage.ALREADY_LOGIN);
        else if (jwt.getExpiresAt().getTime() < now.getTime())
            throw new EdgeComputingServiceException(403, ResponseMessage.ERROR, ResponseMessage.EXPIRED_USER_TOKEN);
        else return userId;
    }

}
