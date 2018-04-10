package com.springboot.learning.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fx on 2018/4/10.
 */
@RestController
public class MainController {

    @RequestMapping("/test")
    public String test(){

        return "yeah!,good.";
    }
}
