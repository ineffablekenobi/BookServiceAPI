package com.ineffable.orderservice.DTO;

import com.ineffable.orderservice.Models.Orders;

import java.util.ArrayList;
import java.util.List;

public class ProductWrapper {
    private List<Long> productIds;

    public ProductWrapper(List<Long> productIds) {
        this.productIds = productIds;
    }

    public ProductWrapper() {
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
