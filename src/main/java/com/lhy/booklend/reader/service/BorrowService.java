package com.lhy.booklend.reader.service;

import com.lhy.booklend.reader.entity.Borrow;

import java.util.Date;
import java.util.List;

public interface BorrowService {
    //查询指定用户的借阅情况
    List<Borrow> findAll(String rNo);
    //插入借书信息
    void insertBorrow(String sNumber, String rNo, String bNo, java.sql.Date bdate);
    //未还书
    List<Borrow> findnotread(String rNo);
    //还书
    void updaterdate(String sNumber,String rNo,String bNo,java.sql.Date rdate);
    //罚款
    void updatefine(String sNumber,String rNo,String bNo,double fine);
    //查询借书时间
    java.sql.Date searchbdate(String sNumber,String rNo,String bNo);
    //罚款原因
    void updatereason(String sNumber,String rNo,String bNo,String reason);
}
