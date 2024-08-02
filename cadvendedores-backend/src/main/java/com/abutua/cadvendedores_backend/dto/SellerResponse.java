package com.abutua.cadvendedores_backend.dto;

public class SellerResponse {
  
  private long id;
  private String name;
  private double salary;
  private double bonus;
  private int gender;


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
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  public double getBonus() {
    return bonus;
  }
  public void setBonus(double bonus) {
    this.bonus = bonus;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
}
