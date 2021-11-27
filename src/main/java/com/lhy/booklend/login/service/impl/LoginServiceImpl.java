package com.lhy.booklend.login.service.impl;

import com.lhy.booklend.login.entity.User;
import com.lhy.booklend.login.mapper.LoginMapper;
import com.lhy.booklend.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public boolean login(String name,String password) {
        //判断是否能登录系统
        User user = loginMapper.selectByname(name);
        if(user==null){
            //找不到用户
            return false;
        }
        if(user.getName().equals("root")&&user.getPassword().equals("root")){
            System.out.println("超级管理员");
        }
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
