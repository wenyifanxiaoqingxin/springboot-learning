package com.springboot.learning.common.initResource;

import com.springboot.learning.common.Property;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/5/11.
 */
@Component
@Order(2)//初始化启动顺序
public class OrderRunderTwo implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("the orderRunderTwo start to initialize...");
        Property property = new Property();
        System.out.println("author by "+property.getName());
    }
}
