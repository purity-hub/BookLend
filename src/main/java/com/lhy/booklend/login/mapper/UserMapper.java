package com.lhy.booklend.login.mapper;

import com.lhy.booklend.login.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    //查找全部用户
    List<User> findAll();
}
