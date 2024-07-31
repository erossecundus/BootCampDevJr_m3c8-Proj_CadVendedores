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
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin
public class SellerController {

  @Autowired
  private SellerService sellerService;

  // private List<Seller> sellers = new ArrayList<>();
    // new Seller(1L, "Joao", 1500.50, 10.0, 1),
    // new Seller(2L, "Maria", 1800.50, 20.0, 2),
    // new Seller(3L, "Darcy", 2000.50, 25.0, 3)

  @GetMapping("sellers")
  public List<Seller> getSellers() {
    return sellerService.getAll();
  }

  @GetMapping("sellers/{id}")
  public ResponseEntity<Seller> getSellerById(@PathVariable long id) {
    Seller seller = sellerService.getById(id);
    return ResponseEntity.ok(seller);
  }

  @PostMapping("sellers")
  public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
    seller = sellerService.save(seller);
    URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(seller.getId())
                    .toUri();
    return ResponseEntity.created(location).body(seller);
  }

  @DeleteMapping("sellers/{id}")
  public ResponseEntity<Void> removeSeller(@PathVariable long id) {
    sellerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("sellers/{id}")
  public ResponseEntity<Seller> updateSeller(@PathVariable long id, @RequestBody Seller sellerUpdate) {
    sellerService.updateById(id, sellerUpdate);
    return ResponseEntity.ok().build();
  }
}
