package io.github.osrb2.e_commerceVipDiscount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.osrb2.e_commerceVipDiscount.model.ProductModel;
import io.github.osrb2.e_commerceVipDiscount.repository.ProductRepository;
import io.github.osrb2.e_commerceVipDiscount.service.factory.ProductFactory;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

  private final ProductFactory factory;
  private final ProductRepository repository;

  public ProductModel  create(ProductModel product) {
    ProductModel newProduct = factory.create(
      product.getName(),
      product.getDescription(),
      product.getPrice(),
      product.getStock(),
      product.getType()  
    );
    return repository.save(newProduct);
  }

  public List<ProductModel> listAllProducts() {
    List<ProductModel> products = repository.findAll();
    return products;
  }

  public Optional<ProductModel> findProductById(Long id) {
    return repository.findById(id);
  }

  public  ProductModel updateProductByID(ProductModel product) {
    ProductModel productToUpdate = repository.findById(product.getId())
      .orElseThrow(() -> new RuntimeException("Product not found!"));

    if (productToUpdate.getName() == product.getName()) {
      throw new RuntimeException("This name already exists!");
    } else {
      Optional.ofNullable(product.getName()).ifPresent(productToUpdate::setName);
    }

    Optional.ofNullable(product.getPrice()).ifPresent(productToUpdate::setPrice);
    Optional.ofNullable(product.getDescription()).ifPresent(productToUpdate::setDescription);
    Optional.ofNullable(product.getStock()).ifPresent(productToUpdate::setStock);

    return repository.save(productToUpdate);  
  }

  public void deleteProductById(Long id) {
    repository.deleteById(id);
  }
}
