package com.ecs.mapper;

import com.ecs.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Select("SELECT # FROM user WHERE id=#{id};")
    User getById(@Param("id") String id);

    @Select("SELECT token_create_at FROM user WHERE id =#{id};")
    String getTokenCreateTime(@Param("id") String id);

    @Insert("INSERT INTO user(uid,username,password,phone,create_at,token_create_at) " +
            "VALUES(#{uid},#{userName},#{password},#{phone},#{create_at},#{token_create_at});")
    void createUser(User user);

    @Update("UPDATE user SET token_create_at=#{tokenCreateTime} WHERE id =#{id};")
    void updateTokenCreateTimeById(@Param("tokenCreateTime") String tokenCreateTime, @Param("id") String id);

    @Update("UPDATE user SET username=#{userName} WHERE id =#{id};")
    void updateUserNameById(@Param("userName") String userName, @Param("id") String id);

    @Update("UPDATE user SET password=#{password} WHERE id =#{id};")
    void updatePasswordById(@Param("password") String password, @Param("id") String id);

    @Update("UPDATE user SET phone=#{phone} WHERE id =#{id};")
    void updatePhoneById(@Param("phone") String phone, @Param("id") String id);

    @Delete("DELETE FROM user WHERE id=#{id};")
    void deleteById(@Param("id") String id);
}