package com.umbra.rest_api;

import java.sql.Date;

public class User {
  private int id;
  private String name;
  private Date birthDate;
  private double income;
  private String ocupation;

  public User(int id, String name, Date birthDate, double income, String ocupation) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.income = income;
    this.ocupation = ocupation;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public double getIncome() {
    return income;
  }

  public void setIncome(double income) {
    this.income = income;
  }

  public String getOcupation() {
    return ocupation;
  }

  public void setOcupation(String ocupation) {
    this.ocupation = ocupation;
  }

}
