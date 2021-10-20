package com.thoughtworks.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thoughtworks.constant.BaseConstants;

import java.util.Date;

public class UserEntity {
    private Long id;

    private String name;

    private int age;

    @JsonFormat(pattern = BaseConstants.TIME_PATTERN, timezone = BaseConstants.TIME_ZONE)
    private Date createdAt;

    @JsonFormat(pattern = BaseConstants.TIME_PATTERN, timezone = BaseConstants.TIME_ZONE)
    private Date updatedAt;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}