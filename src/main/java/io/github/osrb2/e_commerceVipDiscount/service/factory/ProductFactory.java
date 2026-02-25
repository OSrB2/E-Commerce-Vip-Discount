package io.github.osrb2.e_commerceVipDiscount.service.factory;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.github.osrb2.e_commerceVipDiscount.model.ProductModel;
import io.github.osrb2.e_commerceVipDiscount.model.enums.ProductType;

@Component
public class ProductFactory {

  public ProductModel create(
    String name,
    String description,
    BigDecimal price, 
    Integer stock,
    ProductType type
  ) {

    ProductModel product = new ProductModel();

    product.setName(name);
    product.setDescription(description);
    product.setPrice(price);
    product.setStock(stock);
    product.setType(type);
    product.setActive(true);

    applyTypeRules(product);

    return product;
  }

  private void applyTypeRules(ProductModel product) {
    switch (product.getType()) {
      case ELETRONICS:
        validateEletronics(product);
        break;
      case BOOKS:
        validateBook(product);
        break;
      case OTHER:
        break;
      default:
        throw new IllegalArgumentException("Invalid product type!");
    }
  }

  private void validateEletronics(ProductModel product) {
    if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Eletronics must have positive price!");
    }
  }

  private void validateBook(ProductModel product) {
    if (product.getStock() < 0) {
      throw new IllegalArgumentException("Book stock cannotr be negative");
    }
  }
}
