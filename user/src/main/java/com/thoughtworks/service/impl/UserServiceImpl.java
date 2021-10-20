package com.thoughtworks.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thoughtworks.entity.Result;
import com.thoughtworks.entity.UserEntity;
import com.thoughtworks.entity.UserOperateRequest;
import com.thoughtworks.entity.UserQueryRequest;
import com.thoughtworks.feign.EmailFeign;
import com.thoughtworks.mapper.UserMapper;
import com.thoughtworks.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailFeign emailFeign;

    @Override
    public Result<List<UserEntity>> queryUserList(UserQueryRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<UserEntity> users = userMapper.queryUserList(request);
        PageInfo<UserEntity> pageInfo = new PageInfo<>(users);
        return Result.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public Result<UserEntity> addUser(UserOperateRequest request) {
        userMapper.addUser(request);
        Long userId = userMapper.queryMaxUserId(request);
        userMapper.updateUserEmail(userId, getUserEmailAddress(userId));
        return Result.success(queryUserInfo(userId));
    }

    @Override
    public Result<UserEntity> updateUser(UserOperateRequest request) {
        userMapper.updateUser(request);
        return Result.success(queryUserInfo(request.getId()));
    }

    @Override
    public Result<UserEntity> deleteUser(Long userId) {
        UserEntity userEntity = queryUserInfo(userId);
        userMapper.deleteUser(userId);
        return Result.success(userEntity);
    }

    private UserEntity queryUserInfo(Long userId) {
        return userMapper.queryUserByID(userId);
    }

    private String getUserEmailAddress(Long userId) {
        return emailFeign.getUserEmailAddress(userId);
    }
}