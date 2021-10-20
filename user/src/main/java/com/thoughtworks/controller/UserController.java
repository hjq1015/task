package com.thoughtworks.controller;

import com.thoughtworks.entity.Result;
import com.thoughtworks.entity.UserEntity;
import com.thoughtworks.entity.UserOperateRequest;
import com.thoughtworks.entity.UserQueryRequest;
import com.thoughtworks.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/list")
    public Result<List<UserEntity>> queryUserList(@RequestBody UserQueryRequest request) {
        return userService.queryUserList(request);
    }

    @PostMapping("/add")
    public Result<UserEntity> addUser(@RequestBody UserOperateRequest request) {
        return userService.addUser(request);
    }

    @PostMapping("/update")
    public Result<UserEntity> updateUser(@RequestBody UserOperateRequest request) {
        return userService.updateUser(request);
    }

    @PostMapping("/delete")
    public Result<UserEntity> deleteUser(@RequestBody Long userId) {
        return userService.deleteUser(userId);
    }
}