package com.lhy.booklend.book.service.impl;

import com.lhy.booklend.book.entity.Book;
import com.lhy.booklend.book.mapper.BookMapper;
import com.lhy.booklend.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public void edit(String bNo, String isbn, String bDamaged, String bLocation, double bPrice) {
        bookMapper.edit(bNo,isbn,bDamaged,bLocation,bPrice);
    }

    @Override
    public Boolean add(String bNo, String isbn, String bDamaged, String bLocation, double bPrice) {
        //System.out.println(bookMapper.findbNo());
        if(bookMapper.findbNo().contains(bNo)){
            return false;
        }else{
            //不包含bNo
            bookMapper.add(bNo,isbn,bDamaged,bLocation,bPrice);
            return true;
        }

    }

    @Override
    public void delete(String bNo) {
        bookMapper.delete(bNo);
    }

    @Override
    public List<String> findisbn() {
        return bookMapper.findisbn();
    }

    @Override
    public List<Double> findprice(String isbn) {
        return bookMapper.findprice(isbn);
    }

    @Override
    public int getbooknums(String isbn, double bPrice) {
        return bookMapper.getbooknums(isbn,bPrice);
    }

    @Override
    public void updatenums(String isbn, double bPrice, int booknums) {
        bookMapper.updatenums(isbn,bPrice,booknums);
    }

    @Override
    public void updatebDamaged(String bNo, String bDamaged) {
        bookMapper.updatebDamaged(bNo, bDamaged);
    }
}
