package com.ineffable.bookshopgateway;

import com.ineffable.bookshopgateway.DTO.ProductWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BookshopgatewayApplication {

    @Bean
    @LoadBalanced
    public WebClient.Builder getClientBuilder(){
        return WebClient.builder();
    }

    @Bean
    public ProductWrapper getProductWrapper(){
        return new ProductWrapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookshopgatewayApplication.class, args);
    }

}
