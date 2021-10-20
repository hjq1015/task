package com.thoughtworks.service;

import com.thoughtworks.entity.Result;
import com.thoughtworks.entity.UserEntity;
import com.thoughtworks.entity.UserOperateRequest;
import com.thoughtworks.entity.UserQueryRequest;

import java.util.List;

public interface IUserService {
    /**
     * 查询user列表，支持分页查询，支持按名称模糊查询/年龄精准查询/创建时间区间查询
     *
     * @param request 查询条件
     * @return the result of query list
     */
    Result<List<UserEntity>> queryUserList(UserQueryRequest request);

    /**
     * 添加user
     *
     * @param request 添加用户信息
     * @return the result of operation
     */
    Result<UserEntity> addUser(UserOperateRequest request);

    /**
     * 修改user
     *
     * @param request 修改用户信息
     * @return the result of operation
     */
    Result<UserEntity> updateUser(UserOperateRequest request);

    /**
     * 删除user
     *
     * @param userId 用户id
     * @return the result of operation
     */
    Result<UserEntity> deleteUser(Long userId);
}