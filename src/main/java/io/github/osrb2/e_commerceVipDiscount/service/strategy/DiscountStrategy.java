package io.github.osrb2.e_commerceVipDiscount.service.strategy;

import java.math.BigDecimal;

import io.github.osrb2.e_commerceVipDiscount.model.enums.UserRole;

public interface DiscountStrategy {
  UserRole getRole();
  BigDecimal applyDiscount(BigDecimal amount);
}
