package com.springboot.learning.dao;

import com.springboot.learning.entity.mybatis.UserInfo;
import com.springboot.learning.entity.mybatis.UserInfoExample;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
    long countByExample(UserInfoExample example);
}