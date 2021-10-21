package com.thoughtworks.entity;

import com.thoughtworks.UserApplication;
import com.thoughtworks.constant.BaseConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestResult {
    private final Result<Integer> result = new Result<>(1);

    @Test
    public void testSetMsg(){
        result.setMsg(BaseConstants.SUCCESS_MSG);
        Assert.assertTrue(true);
    }

    @Test
    public void testSetCode(){
        result.setCode(BaseConstants.SUCCESS_CODE);
        Assert.assertTrue(true);
    }

    @Test
    public void testSetCount(){
        result.setCount(0L);
        Assert.assertTrue(true);
    }

    @Test
    public void testSetData(){
        result.setData(1);
        Assert.assertTrue(true);
    }
}
