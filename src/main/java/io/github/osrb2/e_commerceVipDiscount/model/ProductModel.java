package io.github.osrb2.e_commerceVipDiscount.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.osrb2.e_commerceVipDiscount.model.enums.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ProductModel {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String description;

  @Column(name = "price", precision = 12, scale = 2, nullable = false)
  private BigDecimal price;

  @Column(name = "stock", nullable = false)
  private Integer stock = 0;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private ProductType type;

  @Column(name = "active", nullable = false)
  private Boolean active = true;

  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime created_at;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updated_at;
}
