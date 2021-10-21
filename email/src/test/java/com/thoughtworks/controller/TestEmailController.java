package com.thoughtworks.controller;

import com.thoughtworks.EmailApplication;
import com.thoughtworks.constant.BaseConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = EmailApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmailController {
    @Autowired
    private EmailController controller;

    @Test
    public void testGetUserEmailAddress() {
        long userId = 34567;
        Assert.assertEquals(userId + BaseConstants.EMAIL_POSTFIX, controller.getUserEmailAddress(userId));
    }
}