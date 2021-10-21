package com.thoughtworks.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.thoughtworks.UserApplication;
import com.thoughtworks.entity.Result;
import com.thoughtworks.entity.UserEntity;
import com.thoughtworks.entity.UserOperateRequest;
import com.thoughtworks.entity.UserQueryRequest;
import com.thoughtworks.mapper.UserMapper;
import com.thoughtworks.service.IUserService;
import org.assertj.core.util.Lists;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserController {
    @Autowired
    private UserController userController;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setup() {
        userMapper = Mockito.mock(UserMapper.class);
        ReflectionTestUtils.setField(userService, "userMapper", userMapper);
    }

    @Test
    public void testQueryUserList() throws JSONException {
        UserQueryRequest queryRequest = new UserQueryRequest();
        queryRequest.setPageNo(1);
        queryRequest.setPageSize(10);
        List<UserEntity> users = Lists.newArrayList();
        users.add(getUserEntity("HuangYong", 32));
        Mockito.when(userMapper.queryUserList(queryRequest)).thenReturn(users);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.queryUserList(queryRequest)),
                JSONObject.toJSONString(Result.success(users, (long) users.size())), false);
    }

    @Test
    public void testAddUser() throws JSONException {
        String name = "ZhangSan";
        int age = 18;
        UserEntity userEntity = getUserEntity(name, age);
        UserOperateRequest request = new UserOperateRequest();
        request.setName(name);
        request.setAge(age);
        Mockito.when(userMapper.addUser(request)).thenReturn(1);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.addUser(request)),
                JSONObject.toJSONString(Result.success(userEntity)), false);
    }

    @Test
    public void testUpdateUser() throws JSONException {
        String name = "ZhangSan";
        int age = 18;
        UserEntity userEntity = getUserEntity(name, age);
        UserOperateRequest request = new UserOperateRequest();
        request.setName(name);
        request.setAge(age);
        Mockito.when(userMapper.addUser(request)).thenReturn(1);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.updateUser(request)),
                JSONObject.toJSONString(Result.success(userEntity)), false);
    }

    @Test
    public void testDeleteUser() throws JSONException {
        String name = "ZhangSan";
        int age = 18;
        UserEntity userEntity = getUserEntity(name, age);
        UserOperateRequest request = new UserOperateRequest();
        request.setName(name);
        request.setAge(age);
        Mockito.when(userMapper.addUser(request)).thenReturn(1);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.deleteUser(request.getId())),
                JSONObject.toJSONString(Result.success(userEntity)), false);
    }

    private UserEntity getUserEntity(String name, int age) {
        Date now = new Date();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName(name);
        userEntity.setAge(age);
        userEntity.setCreatedAt(now);
        userEntity.setUpdatedAt(now);
        return userEntity;
    }
}
