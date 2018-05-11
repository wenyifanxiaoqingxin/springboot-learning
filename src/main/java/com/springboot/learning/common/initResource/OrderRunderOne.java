package com.springboot.learning.common.initResource;

import com.springboot.learning.common.Property;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/11.
 */
@Component
@Order(1)//初始化启动顺序

//项目启动时执行
public class OrderRunderOne implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("the orderRunderOne start to initialize...");
        Property property = new Property();
        //由于在spring加载容器前执行，去除为null
        System.out.println("author by "+property.getName());
    }
}
