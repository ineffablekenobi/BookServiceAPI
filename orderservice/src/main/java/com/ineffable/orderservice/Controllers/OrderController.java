package com.ineffable.orderservice.Controllers;

import com.ineffable.orderservice.DTO.ProductWrapper;
import com.ineffable.orderservice.Exceptions.OrderNotFoundException;
import com.ineffable.orderservice.Models.Orders;
import com.ineffable.orderservice.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductWrapper productWrapper;



    @PostMapping("/new/userid={userid}")
    public void createNewOrder(@PathVariable("userid") Long userid, @RequestBody ProductWrapper wrapper){
        for(int i =0; i < wrapper.getProductIds().size(); i++){
            System.out.println("Product No "+i +": " + wrapper.getProductIds().get(i));
        }
        orderService.createNewOrder(userid,wrapper);
    }

    @GetMapping("/userid={userid}")
    public ProductWrapper getByUserId(@PathVariable("userid")Long id){
        List<Long> ids = orderService.getByUserId(id);
        productWrapper.setProductIds(ids);
        return productWrapper;
    }

    @GetMapping("/orderid={orderid}")
    public Orders getOrderById(@PathVariable("orderid")Long id) throws OrderNotFoundException {
        return orderService.getOrderById(id);
    }

}
