package io.github.osrb2.e_commerceVipDiscount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.osrb2.e_commerceVipDiscount.model.OrderItemsModel;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsModel, Long> {

}
