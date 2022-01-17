package com.ineffable.orderservice.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long userId;
    private Long productIds;

    public Orders() {
    }

    public Orders(Long id, Long userId, Long productIds) {
        this.id = id;
        this.userId = userId;
        this.productIds = productIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductIds() {
        return productIds;
    }

    public void setProductIds(Long orderId) {
        this.productIds = orderId;
    }
}
