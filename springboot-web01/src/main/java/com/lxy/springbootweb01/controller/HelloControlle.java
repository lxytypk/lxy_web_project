package com.lxy.springbootweb01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class HelloControlle {
    @RequestMapping("/helloo")
    public String hello(){
        System.out.println("Hello World~");
        return "Hello World~";
    }
}
