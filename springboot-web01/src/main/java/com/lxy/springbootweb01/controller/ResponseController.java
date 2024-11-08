package com.lxy.springbootweb01.controller;

import com.lxy.springbootweb01.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lxy.springbootweb01.pojo.Address;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    @RequestMapping("/hello1")
    public Result hello1(){
        System.out.println("Hello World~");
        return Result.sucess("Hello World~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr=new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");
        return Result.sucess(addr);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list=new ArrayList<>();
        Address addr=new Address();
        addr.setProvince("广东");
        addr.setCity("深圳");

        Address addr2=new Address();
        addr2.setProvince("陕西");
        addr2.setCity("西安");

        list.add(addr);
        list.add(addr2);
        return Result.sucess(list);
    }
}
