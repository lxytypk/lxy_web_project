package com.lxy;

import com.lxy.mapper.EmpMapper;
import com.lxy.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatis001ApplicationTests {
    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testDelete(){
        empMapper.delete(17);
    }
    @Test
    public void testInsert(){
        Emp emp=new Emp();
        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }
    @Test
    public void testUpdate(){
        Emp emp=new Emp();
        emp.setId(18);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }

    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(18);
        System.out.println(emp);
    }

    @Test
    public void testlist(){
        List<Emp> empList = empMapper.list(null, (short) 1, null, null);
        System.out.println(empList);
    }

    @Test
    public void testUpdate2(){
        Emp emp=new Emp();
        emp.setId(19);
        emp.setUsername("Tom222333");
        /*emp.setName("汤姆222");
        emp.setGender((short)1);
        emp.setUpdateTime(LocalDateTime.now());*/

        empMapper.update2(emp);
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> ids= Arrays.asList(13,14,15);
        empMapper.deleteByIds(ids);
    }
}
