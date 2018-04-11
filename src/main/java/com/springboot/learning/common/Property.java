package com.springboot.learning.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by fx on 2018/4/11.
 */
@Component
public class Property {
    @Value("${com.learning}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
