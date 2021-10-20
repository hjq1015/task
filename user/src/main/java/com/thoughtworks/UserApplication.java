package com.thoughtworks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * User服务
 *
 * @author huangyong
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.thoughtworks.mapper")
public class UserApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(UserApplication.class, args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}