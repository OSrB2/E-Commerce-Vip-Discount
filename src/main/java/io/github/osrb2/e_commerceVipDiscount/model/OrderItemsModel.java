package io.github.osrb2.e_commerceVipDiscount.model;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_items")
@Data
@EntityListeners(AuditingEntityListener.class)
public class OrderItemsModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @Column(name = "order_id", nullable = false)
  private OrderModel order;

  @ManyToOne
  @Column(name = "product_id", nullable = false)
  private ProductModel product;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @Column(name = "price_at_purchase", precision = 12, scale = 2, nullable = false)
  private BigDecimal priceAtPurchase;

  @Column(name = "subtotal", precision = 12, scale = 2, insertable = false, updatable = false)
  private BigDecimal subtotal;
}
