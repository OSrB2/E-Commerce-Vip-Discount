package io.github.osrb2.e_commerceVipDiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.osrb2.e_commerceVipDiscount.model.OrderModel;

@Repository
public interface OrderRepopsitory extends JpaRepository<OrderModel, Long> {

}
