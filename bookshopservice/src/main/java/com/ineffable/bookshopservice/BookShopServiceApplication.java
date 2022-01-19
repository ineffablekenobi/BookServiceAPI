package com.ineffable.bookshopservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookShopServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShopServiceApplication.class, args);
    }

}
