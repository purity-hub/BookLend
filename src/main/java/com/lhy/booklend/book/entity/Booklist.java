package com.lhy.booklend.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booklist {

  private String isbn;
  private String bName;
  private String bClass;
  private String bPublic;
  private String bAuthor;


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }


  public String getBName() {
    return bName;
  }

  public void setBName(String bName) {
    this.bName = bName;
  }


  public String getBClass() {
    return bClass;
  }

  public void setBClass(String bClass) {
    this.bClass = bClass;
  }


  public String getBPublic() {
    return bPublic;
  }

  public void setBPublic(String bPublic) {
    this.bPublic = bPublic;
  }


  public String getBAuthor() {
    return bAuthor;
  }

  public void setBAuthor(String bAuthor) {
    this.bAuthor = bAuthor;
  }

}
