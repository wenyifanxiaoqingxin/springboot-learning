package com.springboot.learning.control;

import com.springboot.learning.entity.User;
import com.springboot.learning.entity.mybatis.UserInfo;
import com.springboot.learning.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fx on 2018/4/12.
 */
@Controller
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/main")
    public String mainHtml(){

        return "login";
    }

   @RequestMapping("/login")
   @ResponseBody
   public String html(Model model, User user){

        String username = user.getUsername();
        String password = user.getPassword();
        UserInfo userInfo = userInfoService.login(username,password);
        if(userInfo!=null){
            return "";

        }else{
            return "";
        }
   }

    @RequestMapping("/success111")
    public String successHtml(){

        return "success111";
    }
}
