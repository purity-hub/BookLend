package com.lhy.booklend.book.mapper;

import com.lhy.booklend.book.entity.Booklist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuyMapper {
    //查找全部的书目
    List<Booklist> findAll();
    //查询isbn集合
    List<String> findByIsbn();
    //查询通过出版社
    List<Booklist> findByPublic(@Param("bPublic") String bPublic);
}
