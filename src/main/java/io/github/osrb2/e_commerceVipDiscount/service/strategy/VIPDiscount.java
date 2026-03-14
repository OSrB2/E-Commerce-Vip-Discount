package io.github.osrb2.e_commerceVipDiscount.service.strategy;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import io.github.osrb2.e_commerceVipDiscount.model.enums.UserRole;

@Component("VIP")
public class VIPDiscount implements DiscountStrategy {

  @Override
  public UserRole getRole() {
    return UserRole.VIP;
  }

  @Override
  public BigDecimal applyDiscount(BigDecimal amount) {
    return amount.multiply(BigDecimal.valueOf(0.80));
  }

 
  
}
