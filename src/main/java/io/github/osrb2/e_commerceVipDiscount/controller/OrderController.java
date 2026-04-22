package io.github.osrb2.e_commerceVipDiscount.controller;

import io.github.osrb2.e_commerceVipDiscount.repository.OrderRepopsitory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.osrb2.e_commerceVipDiscount.model.OrderModel;
import io.github.osrb2.e_commerceVipDiscount.model.UserModel;
import io.github.osrb2.e_commerceVipDiscount.repository.UserRepository;
import io.github.osrb2.e_commerceVipDiscount.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderRepopsitory orderRepository;
  private final OrderService orderService;
  private final UserRepository userRepository;

 
  @PostMapping("/{userId}")
  public ResponseEntity<OrderModel> create(@PathVariable Long userId, @RequestBody @Valid OrderModel order) {
    UserModel user = userRepository.findById(userId)
    .orElseThrow(() -> new RuntimeException("User not found: " + userId));

    OrderModel created = orderService.createOrder(order, user);

    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderModel> findById(@PathVariable Long id) {
    return orderRepository.findById(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());
  }
}
