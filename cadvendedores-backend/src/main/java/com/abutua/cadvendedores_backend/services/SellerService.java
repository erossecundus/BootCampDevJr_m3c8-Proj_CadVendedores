package com.abutua.cadvendedores_backend.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.cadvendedores_backend.models.Seller;
import com.abutua.cadvendedores_backend.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  private SellerRepository sellerRepository;

  public List<Seller> getAll() {
    return sellerRepository.findAll();
  }

  public Seller getById(long id) {
    Seller seller = sellerRepository.findById(id)
                                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not Found"));
    return seller;
  }

  public Seller save(Seller seller) {
    return sellerRepository.save(seller);
  }

  public void deleteById(long id) {
    Seller seller = getById(id);  
    sellerRepository.delete(seller);
  }

  public void updateById(long id, Seller sellerUpdate) {
    Seller seller = getById(id);
    seller.setName(sellerUpdate.getName());
    seller.setSalary(sellerUpdate.getSalary());
    seller.setBonus(sellerUpdate.getBonus());
    seller.setGender(sellerUpdate.getGender());
    sellerRepository.save(seller);
  }


}
