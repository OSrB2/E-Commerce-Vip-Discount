package io.github.osrb2.e_commerceVipDiscount.service.strategy;

import org.springframework.stereotype.Component;

@Component("REGULAR")
public class RegularDiscount implements DiscountStrategy {

  @Override
  public double applyDiscount(double amount) {
    return amount * 0.9;
  }

}
