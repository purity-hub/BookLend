package com.lhy.booklend.book.service.impl;

import com.lhy.booklend.book.entity.Reader;
import com.lhy.booklend.book.mapper.ReaderMapper;
import com.lhy.booklend.book.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderMapper readerMapper;

    @Override
    public List<Reader> findAll() {
        return readerMapper.findAll();
    }

    @Override
    public void updaterSex(String rNo, String rSex) {
        readerMapper.updaterSex(rNo,rSex);
    }

    @Override
    public void updaterIdcard(String rNo, String rIdcard) {
        readerMapper.updaterIdcard(rNo,rIdcard);
    }

    @Override
    public void updaterName(String rNo, String rName) {
        readerMapper.updaterName(rNo,rName);
    }

    @Override
    public void updaterTel(String rNo, String rTel) {
        readerMapper.updaterTel(rNo,rTel);
    }

    @Override
    public void updatecategory(String rNo, String category) {
        readerMapper.updatecategory(rNo,category);
    }

    @Override
    public String searchbyname(String rName) {
        return readerMapper.searchbyname(rName);
    }
}
