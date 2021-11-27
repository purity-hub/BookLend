package com.lhy.booklend.reader.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

  private String sNumber;
  private String rNo;
  private String bNo;
  private java.sql.Date bdate;
  private java.sql.Date rdate;
  private double fine;
  private String reason;
  //新加的属性显示
  private String bLocation;
  private String bName;


  public String getSNumber() {
    return sNumber;
  }

  public void setSNumber(String sNumber) {
    this.sNumber = sNumber;
  }


  public String getRNo() {
    return rNo;
  }

  public void setRNo(String rNo) {
    this.rNo = rNo;
  }


  public String getBNo() {
    return bNo;
  }

  public void setBNo(String bNo) {
    this.bNo = bNo;
  }


  public java.sql.Date getBdate() {
    return bdate;
  }

  public void setBdate(java.sql.Date bdate) {
    this.bdate = bdate;
  }


  public java.sql.Date getRdate() {
    return rdate;
  }

  public void setRdate(java.sql.Date rdate) {
    this.rdate = rdate;
  }


  public double getFine() {
    return fine;
  }

  public void setFine(double fine) {
    this.fine = fine;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
