package com.thoughtworks.mapper;

import com.thoughtworks.entity.UserEntity;
import com.thoughtworks.entity.UserOperateRequest;
import com.thoughtworks.entity.UserQueryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> queryUserList(@Param("user") UserQueryRequest user);

    Integer addUser(@Param("user") UserOperateRequest user);

    Integer updateUserEmail(@Param("userId") Long userId, @Param("email") String email);

    Integer updateUser(@Param("user") UserOperateRequest user);

    Integer deleteUser(@Param("userId") Long userId);

    UserEntity queryUserByID(@Param("userId") Long userId);

    Long queryMaxUserId(@Param("user") UserOperateRequest user);
}