package com.ineffable.orderservice.Services;

import com.ineffable.orderservice.DTO.ProductWrapper;
import com.ineffable.orderservice.Exceptions.OrderNotFoundException;
import com.ineffable.orderservice.Models.Orders;
import com.ineffable.orderservice.Repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;



    public void createNewOrder(Long userid, ProductWrapper wrapper) {
        List<Long> productids = wrapper.getProductIds();
        for(int i = 0; i < productids.size(); i++){
            Orders orders = new Orders();
            orders.setUserId(userid);
            orders.setProductIds(productids.get(i));
            orderRepo.save(orders);
        }
    }


    public List<Orders> getByUserId(Long id) {
        return orderRepo.findByUserId(id);
    }

    public Orders getOrderById(Long id) throws OrderNotFoundException{
        Optional<Orders> order = orderRepo.findById(id);
        if(order.isPresent()){
            return order.get();
        }else {
            throw new OrderNotFoundException("Order Search by ID failed");
        }
    }
}
