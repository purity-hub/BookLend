package com.lhy.booklend.book.mapper;

import com.lhy.booklend.book.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    //查找全部书籍
    List<Book> findAllBooks();
    //修改指定的书籍
    void edit(@Param("bNo") String bNo,@Param("isbn") String isbn,@Param("bDamaged") String bDamaged,@Param("bLocation") String bLocation,@Param("bPrice") double bPrice);
    //增加指定书籍
    void add(@Param("bNo") String bNo,@Param("isbn") String isbn,@Param("bDamaged") String bDamaged,@Param("bLocation") String bLocation,@Param("bPrice") double bPrice);
    //查找所有bNo列表
    List<String> findbNo();
    //删除主键为bNo
    void delete(@Param("bNo") String bNo);
    //查找所有的isbn列表
    List<String> findisbn();
    //通过isbn查询价格
    List<Double> findprice(@Param("isbn") String isbn);
    //通过isbn和价格获取唯一的图书数量
    int getbooknums(@Param("isbn") String isbn,@Param("bPrice") Double bPrice);
    //通过isbn和价格更新相应的数据
    void updatenums(@Param("isbn") String isbn,@Param("bPrice") Double bPrice,@Param("booknums") int booknums);
    //修改破损情况
    void updatebDamaged(@Param("bNo") String bNo,@Param("bDamaged") String bDamaged);
}
