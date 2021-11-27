package com.lhy.booklend.login.service.impl;

import com.lhy.booklend.login.entity.User;
import com.lhy.booklend.login.mapper.UserMapper;
import com.lhy.booklend.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
