package com.springboot.learning.service;

import com.springboot.learning.entity.User;
import com.springboot.learning.entity.mybatis.UserInfo;

/**
 * Created by fx on 2018/4/12.
 */
public interface UserInfoService {
    UserInfo login(String username, String password);
}
