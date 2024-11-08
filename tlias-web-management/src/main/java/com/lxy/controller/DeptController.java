package com.lxy.controller;

import com.lxy.anno.Log;
import com.lxy.pojo.Dept;
import com.lxy.pojo.Result;
import com.lxy.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Scope("prototype")
@Slf4j
@RequestMapping("depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping //指定请求方式为GET
    public Result list(){
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList=deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门{}",id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result find(@PathVariable Integer id){
        log.info("根据id查询数据");
        Dept dept=deptService.findById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门数据");
        deptService.update(dept);
        return Result.success();
    }
}
