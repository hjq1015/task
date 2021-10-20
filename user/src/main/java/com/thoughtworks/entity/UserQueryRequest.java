package com.thoughtworks.entity;

import java.util.Date;

public class UserQueryRequest extends PageInfo {
    private String name;

    private int age;

    private Date createdAtStart;

    private Date createdAtEnd;

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

    public Date getCreatedAtStart() {
        return createdAtStart;
    }

    public void setCreatedAtStart(Date createdAtStart) {
        this.createdAtStart = createdAtStart;
    }

    public Date getCreatedAtEnd() {
        return createdAtEnd;
    }

    public void setCreatedAtEnd(Date createdAtEnd) {
        this.createdAtEnd = createdAtEnd;
    }
}