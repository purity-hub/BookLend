package com.lhy.booklend.login.mapper;

import com.lhy.booklend.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    //通过用户名查找用户,返回一个用户对象
    //@Select("select * from user where name=#{name}")
    User selectByname(@Param("name") String name);
}
