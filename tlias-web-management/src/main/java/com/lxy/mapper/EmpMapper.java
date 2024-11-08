package com.lxy.mapper;

import com.lxy.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /*//查询总记录数
    @Select("select count(*) from emp;")
    public Long count();

    //分页查询，获取列表数据
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(@Param("start") Integer start, @Param("pageSize") Integer pageSize);*/

    //员工信息的查询
    //@Select("select * from emp")
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin")LocalDate begin, @Param("end")LocalDate end);

    void delete(@Param("ids") List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password};")
    Emp getByUsernameAndPassword(Emp emp);

    //根据部门ID删除该部门下的员工数据
    @Delete("delete from emp where dept_id=#{deptId};")
    void deleteByDeptId(Integer deptId);
}
