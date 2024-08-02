package com.abutua.cadvendedores_backend.dto;

import com.abutua.cadvendedores_backend.models.Seller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SellerRequest {
    
  @NotBlank(message = "Name can not be null")
  @Size(min = 5, max = 255, message = "Name lenght min = 5, max = 255")
  private String name;

  @Min(value = 0, message = "Price min value = 0")
  private double salary;

  @Min(value = 0, message = "Bonus min value = 0")
  @Max(value = 100, message = "Bonus max value = 100")
  private double bonus;

  @Min(value = 1, message = "Gender min value = 1")
  @Max(value = 3, message = "Gender max value = 3")
  private int gender;

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

  public Seller toEntity() {
    Seller seller = new Seller();
    seller.setName(name);
    seller.setSalary(salary);
    seller.setBonus(bonus);
    seller.setGender(gender);

    return seller;
  }
}
