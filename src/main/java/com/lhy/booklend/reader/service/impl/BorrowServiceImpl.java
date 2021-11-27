package com.lhy.booklend.reader.service.impl;

import com.lhy.booklend.reader.entity.Borrow;
import com.lhy.booklend.reader.mapper.BorrowMapper;
import com.lhy.booklend.reader.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    BorrowMapper borrowMapper;

    @Override
    public List<Borrow> findAll(String rNo) {
        return borrowMapper.findAll(rNo);
    }

    @Override
    public void insertBorrow(String sNumber, String rNo, String bNo, java.sql.Date bdate) {
        borrowMapper.insertBorrow(sNumber, rNo, bNo, bdate);
    }

    @Override
    public List<Borrow> findnotread(String rNo) {
        return borrowMapper.findnotread(rNo);
    }

    @Override
    public void updaterdate(String sNumber, String rNo, String bNo, Date rdate) {
        borrowMapper.updaterdate(sNumber, rNo, bNo, rdate);
    }

    @Override
    public void updatefine(String sNumber, String rNo, String bNo, double fine) {
        borrowMapper.updatefine(sNumber, rNo, bNo, fine);
    }

    @Override
    public java.sql.Date searchbdate(String sNumber, String rNo, String bNo) {
        return borrowMapper.searchbdate(sNumber, rNo, bNo);
    }

    @Override
    public void updatereason(String sNumber, String rNo, String bNo, String reason) {
        borrowMapper.updatereason(sNumber, rNo, bNo, reason);
    }
}
