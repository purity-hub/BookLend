package com.lhy.booklend.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private long id;
  private String name;
  private String password;
  private long enabled;
  private java.sql.Timestamp registeredTime;
  private String type;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getEnabled() {
    return enabled;
  }

  public void setEnabled(long enabled) {
    this.enabled = enabled;
  }


  public java.sql.Timestamp getRegisteredTime() {
    return registeredTime;
  }

  public void setRegisteredTime(java.sql.Timestamp registeredTime) {
    this.registeredTime = registeredTime;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
