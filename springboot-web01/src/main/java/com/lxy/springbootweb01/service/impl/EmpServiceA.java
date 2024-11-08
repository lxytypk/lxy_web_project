package com.lxy.springbootweb01.service.impl;

import com.lxy.springbootweb01.dao.EmpDao;
import com.lxy.springbootweb01.pojo.Emp;
import com.lxy.springbootweb01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        //1.调用dao，获取数据
        List<Emp> empList=empDao.listEmp();
        //2.对数据进行转换处理 gender、job
        empList.stream().forEach(emp->{
            String gender=emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            String job=emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }
            else if("2".equals(job)){
                emp.setJob("班主任");
            }
            else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
