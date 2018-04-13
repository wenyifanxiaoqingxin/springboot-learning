package com.springboot.learning.service.impl;

import com.springboot.learning.config.PropertyConfiguration;
import com.springboot.learning.dao.UserInfoMapper;
import com.springboot.learning.entity.mybatis.UserInfo;
import com.springboot.learning.entity.mybatis.UserInfoExample;
import com.springboot.learning.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by fx on 2018/4/12.
 */
@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements UserInfoService{

    private UserInfoMapper userInfoMapper;
    private PropertyConfiguration propertyConfiguration;

    @Override
    public UserInfo login(String username, String password) {
        System.out.println(propertyConfiguration.getResource());

        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        if(CollectionUtils.isEmpty(userInfos)){
            return null;
        }else{
            return userInfos.get(0);
        }
    }
}
