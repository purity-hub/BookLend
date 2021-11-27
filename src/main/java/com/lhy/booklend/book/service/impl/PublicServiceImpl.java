package com.lhy.booklend.book.service.impl;

import com.lhy.booklend.book.entity.Public;
import com.lhy.booklend.book.mapper.PublicMapper;
import com.lhy.booklend.book.service.PublicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    PublicMapper publicMapper;
    @Override
    public List<String> findAll() {
        return publicMapper.findAll();
    }

    @Override
    public List<Public> findAllPublic() {
        return publicMapper.findAllPublic();
    }

    @Override
    public void addPublic(String pName, long telegraph, String phone, String zip, String address) {
        publicMapper.addPublic(pName,telegraph,phone,zip,address);
    }
}
