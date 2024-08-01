package com.abutua.cadvendedores_backend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.cadvendedores_backend.models.Seller;
import com.abutua.cadvendedores_backend.services.SellerService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {

  @Autowired
  private SellerService sellerService;

  @GetMapping
  public ResponseEntity<List<Seller>> getSellers() {
    return ResponseEntity.ok(sellerService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<Seller> getSellerById(@PathVariable long id) {
    Seller seller = sellerService.getById(id);
    return ResponseEntity.ok(seller);
  }

  @PostMapping
  public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
    seller = sellerService.save(seller);
    URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(seller.getId())
                    .toUri();
    return ResponseEntity.created(location).body(seller);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> removeSeller(@PathVariable long id) {
    sellerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<Seller> updateSeller(@PathVariable long id, @RequestBody Seller sellerUpdate) {
    sellerService.updateById(id, sellerUpdate);
    return ResponseEntity.ok().build();
  }
}
