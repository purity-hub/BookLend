package com.lhy.booklend.reader.mapper;

import com.lhy.booklend.reader.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BorrowMapper {
    //根据相应的读者用户查询相应的借阅情况
    List<Borrow> findAll(@Param("rNo") String rNo);
    //插入借书信息
    void insertBorrow(@Param("sNumber") String sNumber,@Param("rNo") String rNo,@Param("bNo") String bNo,@Param("bdate") java.sql.Date bdate);
    //未还的图书
    List<Borrow> findnotread(@Param("rNo") String rNo);
    //还书
    void updaterdate(@Param("sNumber") String sNumber,@Param("rNo") String rNo,@Param("bNo") String bNo,@Param("rdate") java.sql.Date rdate);
    //罚款
    void updatefine(@Param("sNumber") String sNumber,@Param("rNo") String rNo,@Param("bNo") String bNo,@Param("fine") double fine);
    //查询借阅时间
    java.sql.Date searchbdate(@Param("sNumber") String sNumber,@Param("rNo") String rNo,@Param("bNo") String bNo);
    //罚款原因
    void updatereason(@Param("sNumber") String sNumber,@Param("rNo") String rNo,@Param("bNo") String bNo,@Param("reason") String reason);
}
