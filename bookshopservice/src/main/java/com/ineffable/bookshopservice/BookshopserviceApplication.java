package com.ineffable.bookshopservice;

import com.ineffable.bookshopservice.DTO.ProductWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaServer
public class BookshopserviceApplication {


    @Bean
    public WebClient.Builder getBuilder(){
        return WebClient.builder();
    }

    @Bean
    public RestTemplate CreateRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ProductWrapper getProductWrapper(){
        return new ProductWrapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookshopserviceApplication.class, args);
    }

}
