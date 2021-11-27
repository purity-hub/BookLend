package com.lhy.booklend.book.service;

import com.lhy.booklend.book.entity.Public;

import java.util.List;

public interface PublicService {
    //查询所有的出版社
    List<String> findAll();
    //查询所有出版社实体
    List<Public> findAllPublic();
    //增加出版社
    void addPublic(String pName,long telegraph,String phone,String zip,String address);
}
