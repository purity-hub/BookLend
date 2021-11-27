package com.lhy.booklend.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Public {

  private String pName;
  private long telegraph;
  private String phone;
  private String zip;
  private String address;


  public String getPName() {
    return pName;
  }

  public void setPName(String pName) {
    this.pName = pName;
  }


  public long getTelegraph() {
    return telegraph;
  }

  public void setTelegraph(long telegraph) {
    this.telegraph = telegraph;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
