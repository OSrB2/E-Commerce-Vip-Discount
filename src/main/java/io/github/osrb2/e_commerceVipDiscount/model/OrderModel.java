package io.github.osrb2.e_commerceVipDiscount.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.osrb2.e_commerceVipDiscount.model.enums.DiscountType;
import io.github.osrb2.e_commerceVipDiscount.model.enums.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
@EntityListeners(AuditingEntityListener.class)
public class OrderModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @Column(name = "user_id", nullable = false)
  private UserModel user;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private OrderStatus status = OrderStatus.PENDING;
 
  @Enumerated(EnumType.STRING)
  @Column(name = "discount_type", nullable = false)
  private DiscountType discountType;

  @Column(name = "discount_amount", precision = 12, scale = 2, nullable = false )
  private BigDecimal discountAmount = BigDecimal.ZERO; 

  @Column(name = "total_gross", precision = 12, scale = 2, nullable = false)
  private BigDecimal totalGross = BigDecimal.ZERO;

  @Column(name = "total_net", precision = 12, scale = 2, nullable = false)
  private BigDecimal totalNet = BigDecimal.ZERO;

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime created_at;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updated_at;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItemsModel> items;
}
