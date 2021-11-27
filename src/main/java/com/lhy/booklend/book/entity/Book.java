package com.lhy.booklend.book.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private String bNo;
  private String isbn;
  private String bDamaged;
  private String bLocation;
  private double bPrice;
  private java.sql.Date bookdate;
  private long booknums;
  private String bookname;


  public String getBNo() {
    return bNo;
  }

  public void setBNo(String bNo) {
    this.bNo = bNo;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }


  public String getBDamaged() {
    return bDamaged;
  }

  public void setBDamaged(String bDamaged) {
    this.bDamaged = bDamaged;
  }


  public String getBLocation() {
    return bLocation;
  }

  public void setBLocation(String bLocation) {
    this.bLocation = bLocation;
  }


  public double getBPrice() {
    return bPrice;
  }

  public void setBPrice(double bPrice) {
    this.bPrice = bPrice;
  }


  public java.sql.Date getBookdate() {
    return bookdate;
  }

  public void setBookdate(java.sql.Date bookdate) {
    this.bookdate = bookdate;
  }


  public long getBooknums() {
    return booknums;
  }

  public void setBooknums(long booknums) {
    this.booknums = booknums;
  }

}
