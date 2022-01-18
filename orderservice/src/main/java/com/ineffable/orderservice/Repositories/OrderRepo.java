package com.ineffable.orderservice.Repositories;

import com.ineffable.orderservice.Models.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepo extends CrudRepository<Orders, Long> {
    public List<Orders> findByUserId(Long userId);
}
