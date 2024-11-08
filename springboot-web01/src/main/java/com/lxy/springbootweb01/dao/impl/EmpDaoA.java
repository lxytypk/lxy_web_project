package com.lxy.springbootweb01.dao.impl;

import com.lxy.springbootweb01.dao.EmpDao;
import com.lxy.springbootweb01.pojo.Emp;
import com.lxy.springbootweb01.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
