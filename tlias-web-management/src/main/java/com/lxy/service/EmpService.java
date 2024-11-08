package com.lxy.service;

import com.lxy.pojo.Emp;
import com.lxy.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //分页查询
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
