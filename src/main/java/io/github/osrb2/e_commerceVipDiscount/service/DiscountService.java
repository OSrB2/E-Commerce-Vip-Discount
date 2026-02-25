package io.github.osrb2.e_commerceVipDiscount.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.service.strategy.DiscountStrategy;

@Service
public class DiscountService {
  
  private final Map<String, DiscountStrategy> strategies;

  public DiscountService(Map<String, DiscountStrategy> strategies) {
    this.strategies = strategies;
  }

  public double applyDiscount(UserModel user, double amount) {
    DiscountStrategy strategy = strategies.get(user.getRole().name());
    return strategy.applyDiscount(amount);
  }
}
