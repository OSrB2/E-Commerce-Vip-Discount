package io.github.osrb2.e_commerceVipDiscount.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.service.strategy.DiscountStrategy;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscountService {
  
  private final Map<String, DiscountStrategy> strategies;

  public BigDecimal applyDiscount(UserModel user, BigDecimal total) {
    DiscountStrategy strategy = strategies.get(user.getRole());
    return strategy.applyDiscount(total);
  }
 
}
