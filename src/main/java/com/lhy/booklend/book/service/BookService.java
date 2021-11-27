package com.lhy.booklend.book.service;

import com.lhy.booklend.book.entity.Book;

import java.util.List;

public interface BookService {
    //查询所有书籍
    List<Book> findAllBooks();
    //修改图书信息
    void edit(String bNo,String isbn,String bDamaged,String bLocation,double bPrice);
    //添加书籍
    Boolean add(String bNo,String isbn,String bDamaged,String bLocation,double bPrice);
    //删除书籍
    void delete(String bNo);
    //查找所有的isbn列表
    List<String> findisbn();
    //查询价格
    List<Double> findprice(String isbn);
    //通过isbn和价格查询图书数量
    int getbooknums(String isbn,double bPrice);
    //通过isbn和价格更新相应的数据
    void updatenums(String isbn,double bPrice,int booknums);
    //更新破损情况
    void updatebDamaged(String bNo,String bDamaged);
}
