package io.github.osrb2.e_commerceVipDiscount.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import io.github.osrb2.e_commerceVipDiscount.model.OrderModel;
import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
  private final DiscountService discountService;

  public OrderModel createOrder(UserModel user, BigDecimal totalGross) {

    BigDecimal totalNet = discountService.applyDiscount(user, totalGross);

    OrderModel order = new OrderModel();
    order.setUser(user);
    order.setTotalGross(totalGross);
    order.setTotalNet(totalNet);
    order.setDiscountAmount(totalGross.subtract(totalNet));

    return order;
  }
}
