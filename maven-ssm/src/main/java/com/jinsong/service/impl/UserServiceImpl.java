package com.jinsong.service.impl;

import com.jinsong.bean.User;

import com.jinsong.mapper.UserMapper;
import com.jinsong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangjinsong
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/8/10 14:24
 * @Created by tangjinsong
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {


        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User seByid() {
        return userMapper.seByid();
    }
}
