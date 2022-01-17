package com.ineffable.orderservice;

import com.ineffable.orderservice.DTO.ProductWrapper;
import com.ineffable.orderservice.Models.Orders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderserviceApplication {

    @Bean
    public ProductWrapper productWrapperBuilder(){
        return new ProductWrapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);
    }

}
