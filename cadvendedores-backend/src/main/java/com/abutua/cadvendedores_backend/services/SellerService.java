package com.abutua.cadvendedores_backend.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.cadvendedores_backend.dto.SellerRequest;
import com.abutua.cadvendedores_backend.dto.SellerResponse;
import com.abutua.cadvendedores_backend.models.Seller;
import com.abutua.cadvendedores_backend.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  private SellerRepository sellerRepository;

  public List<SellerResponse> getAll() {
    return sellerRepository.findAll()
                           .stream()
                           .map(s -> s.toDTO())
                           .collect(Collectors.toList());
  }

  public Seller getById(long id) {
    Seller seller = sellerRepository.findById(id)
                                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not Found"));
    return seller;
  }
  
  public SellerResponse getDTOById(long id) {
    Seller seller = sellerRepository.findById(id)
                                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not Found"));
    return seller.toDTO();
  }


  public SellerResponse save(SellerRequest sellerRequest) {
    Seller seller = sellerRepository.save(sellerRequest.toEntity());
    return seller.toDTO();
  }

  public void deleteById(long id) {
    Seller seller = getById(id);  
    sellerRepository.delete(seller);
  }

  public void updateById(long id, SellerRequest sellerUpdate) {
    Seller seller = getById(id);
    seller.setName(sellerUpdate.getName());
    seller.setSalary(sellerUpdate.getSalary());
    seller.setBonus(sellerUpdate.getBonus());
    seller.setGender(sellerUpdate.getGender());
    sellerRepository.save(seller);
  }

}
