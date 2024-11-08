package com.lxy.service.impl;

import com.lxy.mapper.DeptMapper;
import com.lxy.mapper.EmpMapper;
import com.lxy.pojo.Dept;
import com.lxy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class) //spring事务管理
    @Override
    public void delete(Integer id) throws Exception {
        deptMapper.deleteById(id); //根据ID删除部门
        //int i=1/0;
//        if(true){
//            throw new Exception("出错啦！");
//        }
        empMapper.deleteByDeptId(id); //根据部门ID删除该部门下员工
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}