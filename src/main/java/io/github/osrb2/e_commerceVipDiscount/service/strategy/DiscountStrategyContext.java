package io.github.osrb2.e_commerceVipDiscount.service.strategy;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.github.osrb2.e_commerceVipDiscount.model.enums.UserRole;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DiscountStrategyContext {

  private final Map<String, DiscountStrategy> strategies;

  public BigDecimal applyDiscount(UserRole role, BigDecimal amount) {
    DiscountStrategy strategy = strategies.get(role.name());

    if (strategy == null) {
      throw new IllegalArgumentException("No discount strategy found for role: " + role);
    }

    return strategy.applyDiscount(amount);
  }
}
