package com.thoughtworks.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.thoughtworks.UserApplication;
import com.thoughtworks.constant.BaseConstants;
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
    private static final String NAME = "ZhangSan";
    private static final int AGE = 18;

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
    public void testQueryUserList01() throws JSONException {
        UserQueryRequest queryRequest = new UserQueryRequest();
        queryRequest.setPageNo(1);
        queryRequest.setPageSize(10);
        queryRequest.setOrderBy(BaseConstants.DEFAULT_ORDER_BY_FIELD);
        queryRequest.setAge(AGE);
        queryRequest.setName(NAME);
        queryRequest.setCreatedAtStart(new Date());
        queryRequest.setCreatedAtEnd(new Date());
        List<UserEntity> users = Lists.newArrayList();
        users.add(getUserEntity(NAME, AGE));
        Mockito.when(userMapper.queryUserList(queryRequest)).thenReturn(users);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.queryUserList(queryRequest)),
                JSONObject.toJSONString(Result.success(users, (long) users.size())), false);
    }

    @Test
    public void testQueryUserList02() throws JSONException {
        UserQueryRequest queryRequest = new UserQueryRequest();
        queryRequest.setPageNo(1);
        queryRequest.setPageSize(10);
        queryRequest.setAge(AGE);
        queryRequest.setName(NAME);
        queryRequest.setCreatedAtStart(new Date());
        queryRequest.setCreatedAtEnd(new Date());
        List<UserEntity> users = Lists.newArrayList();
        users.add(getUserEntity(NAME, AGE));
        Mockito.when(userMapper.queryUserList(queryRequest)).thenReturn(users);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.queryUserList(queryRequest)),
                JSONObject.toJSONString(Result.success(users, (long) users.size())), false);
    }

    @Test
    public void testAddUser() throws JSONException {
        UserEntity userEntity = getUserEntity(NAME, AGE);
        UserOperateRequest request = new UserOperateRequest();
        request.setName(NAME);
        request.setAge(AGE);
        Mockito.when(userMapper.addUser(request)).thenReturn(1);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.addUser(request)),
                JSONObject.toJSONString(Result.success(userEntity)), false);
    }

    @Test
    public void testUpdateUser() throws JSONException {
        UserEntity userEntity = getUserEntity(NAME, AGE);
        UserOperateRequest request = new UserOperateRequest();
        request.setId(1L);
        request.setName(NAME);
        request.setAge(AGE);
        Mockito.when(userMapper.addUser(request)).thenReturn(1);
        JSONAssert.assertEquals(JSONObject.toJSONString(userController.updateUser(request)),
                JSONObject.toJSONString(Result.success(userEntity)), false);
    }

    @Test
    public void testDeleteUser() throws JSONException {
        UserEntity userEntity = getUserEntity(NAME, AGE);
        UserOperateRequest request = new UserOperateRequest();
        request.setName(NAME);
        request.setAge(AGE);
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
        userEntity.setEmail(null);
        userEntity.setCreatedAt(now);
        userEntity.setUpdatedAt(now);
        return userEntity;
    }
}
