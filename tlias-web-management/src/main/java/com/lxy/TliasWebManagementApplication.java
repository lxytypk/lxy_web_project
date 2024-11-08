package com.lxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@ServletComponentScan({"com.lxy","com.example"}) //开启了对servlet组件的支持
/*
@Import({TokenParser.class}) //导入普通类，交给IOC容器管理
@Import({HeaderConfig.class}) //导入配置类，交给IOC容器管理
@Import({MyImportSelector.class}) //导入ImportSelector接口实现类，交给IOC容器管理
*/

@SpringBootApplication
public class TliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagementApplication.class, args);
    }

}