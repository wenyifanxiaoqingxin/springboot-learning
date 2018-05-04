package com.springboot.learning.action;

import com.springboot.learning.common.redis.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fx on 2018/4/10.
 */
@RestController
public class MainController {
    @Autowired
    private Redis redis;

    @RequestMapping("/test")
    public String test(){

        return "yeah!,good.";
    }

    @RequestMapping("/redisData/{id}")
    public String redisData(@PathVariable("id") String id){
        redis.set("FEATRUE_"+id,id);

        String str = (String) redis.get("FEATRUE_"+id);
        return str;
    }
}
