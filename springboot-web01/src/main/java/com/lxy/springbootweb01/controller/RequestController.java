package com.lxy.springbootweb01.controller;

import com.lxy.springbootweb01.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name") String username, Integer age){
        System.out.println(username+" "+age);
        return "OK!";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK!";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "OK!";
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK!";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK!";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")LocalDateTime updatetime){
        System.out.println(updatetime);
        return "OK!";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK!";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK!";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK!";
    }
}