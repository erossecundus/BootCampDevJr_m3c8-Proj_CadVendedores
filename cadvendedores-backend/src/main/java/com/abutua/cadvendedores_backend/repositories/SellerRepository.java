package com.abutua.cadvendedores_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abutua.cadvendedores_backend.models.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long>{
  
}
