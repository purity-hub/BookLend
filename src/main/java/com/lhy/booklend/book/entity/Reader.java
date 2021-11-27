package com.lhy.booklend.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

  private String rNo;
  private String rIdcard;
  private String rName;
  private String rSex;
  private java.sql.Date rBirthday;
  private String rTel;
  private long enabled;
  private String category;


  public String getRNo() {
    return rNo;
  }

  public void setRNo(String rNo) {
    this.rNo = rNo;
  }


  public String getRIdcard() {
    return rIdcard;
  }

  public void setRIdcard(String rIdcard) {
    this.rIdcard = rIdcard;
  }


  public String getRName() {
    return rName;
  }

  public void setRName(String rName) {
    this.rName = rName;
  }


  public String getRSex() {
    return rSex;
  }

  public void setRSex(String rSex) {
    this.rSex = rSex;
  }


  public java.sql.Date getRBirthday() {
    return rBirthday;
  }

  public void setRBirthday(java.sql.Date rBirthday) {
    this.rBirthday = rBirthday;
  }


  public String getRTel() {
    return rTel;
  }

  public void setRTel(String rTel) {
    this.rTel = rTel;
  }


  public long getEnabled() {
    return enabled;
  }

  public void setEnabled(long enabled) {
    this.enabled = enabled;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

}
