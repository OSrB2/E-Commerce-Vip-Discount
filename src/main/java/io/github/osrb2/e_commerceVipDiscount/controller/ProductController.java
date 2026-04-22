package io.github.osrb2.e_commerceVipDiscount.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.osrb2.e_commerceVipDiscount.model.ProductModel;
import io.github.osrb2.e_commerceVipDiscount.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService service;

  @PostMapping()
  public ResponseEntity<ProductModel> registerProduct(@RequestBody @Valid ProductModel product) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(product));
  }

  @GetMapping()
  public ResponseEntity<List<ProductModel>> listAll() {
    return ResponseEntity.ok(service.listAllProducts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<ProductModel>> findById(@PathVariable Long id) {
    return ResponseEntity.ok(service.findProductById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductModel product) {
    product.setId(id);
    return ResponseEntity.ok(service.updateProductByID(product));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    service.deleteProductById(id);
    return ResponseEntity.noContent().build();
  } 
}
