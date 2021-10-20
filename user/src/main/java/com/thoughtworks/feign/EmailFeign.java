package com.thoughtworks.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EMAIL-SERVICE")
public interface EmailFeign {
    @GetMapping("/v1/email/address")
    String getUserEmailAddress(@RequestParam("userId") Long userId);
}