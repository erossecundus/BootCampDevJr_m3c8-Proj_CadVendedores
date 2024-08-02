package com.abutua.cadvendedores_backend.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abutua.cadvendedores_backend.dto.SellerRequest;
import com.abutua.cadvendedores_backend.dto.SellerResponse;
import com.abutua.cadvendedores_backend.models.Seller;
import com.abutua.cadvendedores_backend.repositories.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

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

  public SellerResponse getById(long id) {
    Seller seller = sellerRepository.findById(id)
                                    .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    return seller.toDTO();
  }

  public SellerResponse save(SellerRequest sellerRequest) {
    Seller seller = sellerRepository.save(sellerRequest.toEntity());
    return seller.toDTO();
  }

  public void deleteById(long id) {
    if (!sellerRepository.existsById(id)) {
      throw new EntityNotFoundException("Seller not found");
    }
    sellerRepository.deleteById(id);
  }

  public void updateById(long id, SellerRequest sellerUpdate) {

    try {
      Seller seller = sellerRepository.getReferenceById(id);
      
      seller.setName(sellerUpdate.getName());
      seller.setSalary(sellerUpdate.getSalary());
      seller.setBonus(sellerUpdate.getBonus());
      seller.setGender(sellerUpdate.getGender());
      sellerRepository.save(seller);
    } catch (EntityNotFoundException e) {
      throw new EntityNotFoundException("Seller not found");
    }

  }

}
