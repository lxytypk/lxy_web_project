package com.lxy.service;

import com.lxy.pojo.Dept;

import java.util.List;

public interface DeptService {

    //查询全部部门数据
    List<Dept> list();

    //删除部门
    void delete(Integer id) throws Exception;

    void add(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
