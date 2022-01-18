package com.ineffable.orderservice.Controllers;

import com.ineffable.orderservice.DTO.OrderWrapper;
import com.ineffable.orderservice.DTO.ProductWrapper;
import com.ineffable.orderservice.Exceptions.OrderNotFoundException;
import com.ineffable.orderservice.Models.Orders;
import com.ineffable.orderservice.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductWrapper productWrapper;

    @Autowired
    private OrderWrapper orderWrapper;



    @PostMapping("/new/userid={userid}")
    public void createNewOrder(@PathVariable("userid") Long userid, @RequestBody ProductWrapper wrapper){
        for(int i =0; i < wrapper.getProductIds().size(); i++){
            System.out.println("Product No "+i +": " + wrapper.getProductIds().get(i));
        }
        orderService.createNewOrder(userid,wrapper);
    }

    @GetMapping("/userid={userid}")
    public OrderWrapper getByUserId(@PathVariable("userid")Long id){
        List<Orders> orders = orderService.getByUserId(id);
        orderWrapper.setOrdersList(orders);
        return orderWrapper;
    }

    @GetMapping("/orderid={orderid}")
    public Orders getOrderById(@PathVariable("orderid")Long id) throws OrderNotFoundException {
        return orderService.getOrderById(id);
    }

}
