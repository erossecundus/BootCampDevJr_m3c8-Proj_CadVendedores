package com.abutua.cadvendedores_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.cadvendedores_backend.models.Seller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SellerController {

  private List<Seller> sellers = new ArrayList<>();
    // new Seller(1L, "Joao", 1500.50, 10.0, 1),
    // new Seller(2L, "Maria", 1800.50, 20.0, 2),
    // new Seller(3L, "Darcy", 2000.50, 25.0, 3)

  @GetMapping("sellers")
  public ResponseEntity<List<Seller>> getSellers() {
    return ResponseEntity.ok(sellers);
  }

  @GetMapping("sellers/{id}")
  public ResponseEntity<Seller> getSellerById(@PathVariable int id) {
    Seller seller = sellers.stream()
                           .filter(p -> p.getId() == id)
                           .findFirst()
                           .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not Found"));
    return ResponseEntity.ok(seller);
  }

  @PostMapping("sellers")
  public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
    seller.setId(sellers.size()+1L);
    sellers.add(seller);
    URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(seller.getId())
                    .toUri();

    return ResponseEntity.created(location).body(seller);
  }
}
