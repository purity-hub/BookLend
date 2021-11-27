package com.lhy.booklend.book.service;

import com.lhy.booklend.book.entity.Booklist;

import java.util.List;

public interface BuyService {
    //查询所有书目
    List<Booklist> findAll();
    //查询所有isbn集合
    List<String> findByIsbn();
    //查询通过出版社
    List<Booklist> findByPublic(String bPublic);
}
