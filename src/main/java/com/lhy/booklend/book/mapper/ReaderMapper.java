package com.lhy.booklend.book.mapper;


import com.lhy.booklend.book.entity.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReaderMapper {
    //查询全部读者信息
    List<Reader> findAll();
    //更新性别
    void updaterSex(@Param("rNo") String rNo,@Param("rSex") String rSex);
    //更新借书证
    void updaterIdcard(@Param("rNo") String rNo,@Param("rIdcard") String rIdcard);
    //更新姓名
    void updaterName(@Param("rNo") String rNo,@Param("rName") String rName);
    //更新电话
    void updaterTel(@Param("rNo") String rNo,@Param("rTel") String rTel);
    //更新类别
    void updatecategory(@Param("rNo") String rNo,@Param("category") String category);
    //通过名字查询bNo
    String searchbyname(@Param("rName") String rName);
}
