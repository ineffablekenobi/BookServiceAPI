package com.ineffable.bookshopservice.DTO;

import com.ineffable.bookshopservice.Models.Orders;

import java.util.List;

public class OrderWrapper {
    private List<Orders> ordersList;

    public OrderWrapper(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public OrderWrapper() {
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
