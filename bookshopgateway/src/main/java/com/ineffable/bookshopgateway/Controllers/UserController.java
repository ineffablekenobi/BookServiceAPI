package com.ineffable.bookshopgateway.Controllers;

import com.ineffable.bookshopgateway.DTO.UserWrapper;
import com.ineffable.bookshopgateway.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String url = "http://user-service/users";

    @GetMapping("/")
    public UserWrapper getAllUser(){

        return webClientBuilder.build()
                .get()
                .uri(url + "/")
                .retrieve()
                .bodyToMono(UserWrapper.class)
                .block();
    }

    @GetMapping("/userid={id}")
    public User getUserById(@PathVariable("id")Long id){
        return webClientBuilder.build()
                .get()
                .uri(url + "/userid=" + id)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }


    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        webClientBuilder.build()
                .post()
                .uri(url +"/add")
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    @DeleteMapping("/delete/userid={userid}")
    public void deleteUser(@PathVariable("userid") Long id){
        webClientBuilder.build()
                .delete()
                .uri(url +"/delete/userid=" +id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
