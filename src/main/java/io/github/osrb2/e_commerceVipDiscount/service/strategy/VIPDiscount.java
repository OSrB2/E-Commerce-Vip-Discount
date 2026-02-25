package io.github.osrb2.e_commerceVipDiscount.service.strategy;

import org.springframework.stereotype.Component;

@Component("VIP")
public class VIPDiscount implements DiscountStrategy {

  @Override
  public double applyDiscount(double amount) {
    return amount * 0.8;
  }
  
}
