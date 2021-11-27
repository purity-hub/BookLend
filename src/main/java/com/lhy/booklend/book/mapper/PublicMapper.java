package com.lhy.booklend.book.mapper;

import com.lhy.booklend.book.entity.Public;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublicMapper {
    //查询所有的出版社列表
    List<String> findAll();
    //查询所有出版社实体
    List<Public> findAllPublic();
    //增加出版社
    void addPublic(@Param("pName") String pName,@Param("telegraph") long telegraph,@Param("phone") String phone,@Param("zip") String zip,@Param("address") String address);
}
