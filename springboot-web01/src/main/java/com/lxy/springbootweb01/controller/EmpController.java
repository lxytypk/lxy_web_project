package com.lxy.springbootweb01.controller;

import com.lxy.springbootweb01.pojo.Emp;
import com.lxy.springbootweb01.pojo.Result;
import com.lxy.springbootweb01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
        /*//1.加载并解析emp.xml
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList= XmlParserUtils.parse(file, Emp.class);

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

        //3.响应数据
        return Result.sucess(empList);*/

        List<Emp> empList = empService.listEmp();
        //响应数据
        return Result.sucess(empList);
    }
}
