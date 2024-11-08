package com.lxy;

import com.lxy.controller.DeptController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    /*
    * 生成JWT
    * */
    @Test
    public void testGenJwt(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
                .setClaims(claims) //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //设置有效期为1h
                .compact();
        System.out.println(jwt); //eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTczMDY0OTQ2MX0.Y0m3gje1PuqHmJ_2E1KJHByFQA-IzulxWixZDPtyHB8
    }

    /*
    解析JWT
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTczMDY0OTQ2MX0.Y0m3gje1PuqHmJ_2E1KJHByFQA-IzulxWixZDPtyHB8")
                .getBody();
        System.out.println(claims); //{name=tom, id=1, exp=1730649461}
    }

    @Autowired
    private ApplicationContext applicationContext; //IOC容器对象
    
    @Test
    public void testGetBean(){
        //根据bean的名称获取
        DeptController bean1= (DeptController) applicationContext.getBean("deptController");
        System.out.println(bean1);

        //根据bean的类型获取
        DeptController bean2 = applicationContext.getBean(DeptController.class);
        System.out.println(bean2);

        //根据bean的名称 及 类型获取
        DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
        System.out.println(bean3);
        System.out.println("test git lxy!");
        System.out.println("master test!");
        System.out.println("hot-fix test!");
    }

}
