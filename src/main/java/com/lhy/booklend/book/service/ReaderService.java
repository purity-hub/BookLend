package com.lhy.booklend.book.service;

import com.lhy.booklend.book.entity.Reader;

import java.util.List;

public interface ReaderService {
    //查询所有的读者信息
    List<Reader> findAll();
    //更新性别
    void updaterSex(String rNo,String rSex);
    //更新借书证
    void updaterIdcard(String rNo,String rIdcard);
    //更新姓名
    void updaterName(String rNo,String rName);
    //更新电话
    void updaterTel(String rNo,String rTel);
    //更新类别
    void updatecategory(String rNo,String category);
    //查询名字对应的bNo
    String searchbyname(String rName);
}
