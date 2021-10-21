package com.thoughtworks.entity;

import com.thoughtworks.UserApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserOperateRequest {
    private final UserOperateRequest request = new UserOperateRequest();

    private static final String NAME = "HuangYong";

    private static final Integer AGE = 32;

    private static final Date DATE = new Date();

    @Before
    public void setup() {
        request.setName(NAME);
        request.setAge(AGE);
    }


    @Test
    public void testGetName() {
        Assert.assertTrue(NAME.equals(request.getName()));
    }

    @Test
    public void testGetAge() {
        Assert.assertTrue(AGE.equals(request.getAge()));
    }
}