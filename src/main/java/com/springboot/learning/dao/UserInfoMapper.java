package com.springboot.learning.dao;

import com.springboot.learning.entity.mybatis.UserInfo;
import com.springboot.learning.entity.mybatis.UserInfoExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserInfoMapper extends Mapper<UserInfo> {
    long countByExample(UserInfoExample example);
}