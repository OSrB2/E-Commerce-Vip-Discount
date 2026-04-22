package io.github.osrb2.e_commerceVipDiscount.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import io.github.osrb2.e_commerceVipDiscount.model.OrderModel;
import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.model.enums.DiscountType;
import io.github.osrb2.e_commerceVipDiscount.model.enums.OrderStatus;
import io.github.osrb2.e_commerceVipDiscount.repository.OrderRepopsitory;
import io.github.osrb2.e_commerceVipDiscount.service.strategy.DiscountStrategyContext;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

  private final OrderRepopsitory orderRepopsitory;
  private final DiscountStrategyContext discountContext;

  public OrderModel createOrder(OrderModel order, UserModel user) {

    order.getItems().forEach(item -> item.setOrder(order));

    BigDecimal totalGross = calculateGross(order);
    BigDecimal totalNet =  discountContext.applyDiscount(user.getRole(), totalGross);
    BigDecimal discountAmount = totalGross.subtract(totalNet);

    order.setUser(user);
    order.setTotalGross(totalGross);
    order.setTotalNet(totalNet);
    order.setDiscountAmount(discountAmount);
    order.setDiscountType(DiscountType.valueOf(user.getRole().name()));
    order.setStatus(OrderStatus.PENDING);

    return orderRepopsitory.save(order);
  }

  private BigDecimal calculateGross(OrderModel order) {
    return order.getItems().stream()
    .map(item -> item.getPriceAtPurchase()
      .multiply(BigDecimal.valueOf(item.getQuantity())))
    .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
