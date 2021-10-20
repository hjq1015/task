package com.thoughtworks.controller;

import com.thoughtworks.constant.BaseConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/email")
@RestController
public class EmailController {
    @GetMapping("/address")
    public String getUserEmailAddress(@RequestParam("userId") Long userId) {
        return userId + BaseConstants.EMAIL_POSTFIX;
    }
}