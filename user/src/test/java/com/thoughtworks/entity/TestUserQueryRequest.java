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
public class TestUserQueryRequest {
    private final UserQueryRequest request = new UserQueryRequest();

    private static final String NAME = "HuangYong";

    private static final Integer AGE = 32;

    private static final Date DATE = new Date();

    @Before
    public void setup() {
        request.setName(NAME);
        request.setAge(AGE);
        request.setCreatedAtEnd(DATE);
        request.setCreatedAtStart(DATE);
    }


    @Test
    public void testGetName() {
        Assert.assertTrue(NAME.equals(request.getName()));
    }

    @Test
    public void testGetAge() {
        Assert.assertTrue(AGE.equals(request.getAge()));
    }

    @Test
    public void testGetCreatedAtStart() {
        Assert.assertTrue(DATE.equals(request.getCreatedAtStart()));
    }

    @Test
    public void testGetCreatedAtEnd() {
        Assert.assertTrue(DATE.equals(request.getCreatedAtEnd()));
    }
}