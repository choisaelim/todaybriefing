package com.example.order.jpa;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
// @EntityListeners(AuditingEntityListener.class)
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

    // @Column(updatable = false, insertable = false)
    // @Setter(value = AccessLevel.NONE)
    // // // @ColumnDefault(value = "CURRENT_TIMESTAMP")
    // @CreatedDate
    // private Date createdAt;

    @CreationTimestamp
    private Instant createdAt;

    // @PrePersist
    // public void createdAt() {
    // this.createdAt = LocalDateTime.now();
    // }
}
