package com.lhy.booklend.book.service.impl;

import com.lhy.booklend.book.entity.Booklist;
import com.lhy.booklend.book.mapper.BuyMapper;
import com.lhy.booklend.book.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyServiceImpl implements BuyService {

    @Autowired
    BuyMapper buyMapper;

    @Override
    public List<Booklist> findAll() {
        return buyMapper.findAll();
    }

    @Override
    public List<String> findByIsbn() {
        return buyMapper.findByIsbn();
    }

    @Override
    public List<Booklist> findByPublic(String bPublic) {
        return buyMapper.findByPublic(bPublic);
    }
}
