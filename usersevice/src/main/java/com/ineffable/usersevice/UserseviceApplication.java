package com.ineffable.usersevice;

import com.ineffable.usersevice.DTO.UserWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class UserseviceApplication {

    @Bean
    public UserWrapper createUserWrapper(){
        return new UserWrapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserseviceApplication.class, args);
    }

}
