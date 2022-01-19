package com.ineffable.bookshopgateway.Controllers;


import com.ineffable.bookshopgateway.DTO.OrderWrapper;
import com.ineffable.bookshopgateway.DTO.ProductWrapper;
import com.ineffable.bookshopgateway.Models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ProductWrapper productWrapper;

    private final String url = "http://orders-service/order";

    @GetMapping("/orderid={orderid}")
    public Orders getOrderById(@PathVariable("orderid")Long id) {
        Orders response = webClientBuilder.build()
                .get()
                .uri(url +"/orderid=" +id)
                .retrieve()
                .bodyToMono(Orders.class)
                .block();
        return response;
    }

    @GetMapping("/userid={userid}")
    public OrderWrapper getByUserId(@PathVariable("userid")Long id){
        OrderWrapper response = webClientBuilder.build()
                .get()
                .uri(url +"/userid=" + id)
                .retrieve()
                .bodyToMono(OrderWrapper.class)
                .block();
        return response;
    }

    @PostMapping("/new/userid={userid}")
    public void createNewOrder(@PathVariable("userid") Long userid, @RequestBody ProductWrapper wrapper){
        webClientBuilder.build()
                .post()
                .uri(url+"/new/userid="+userid)
                .body(Mono.just(wrapper),ProductWrapper.class)
                .retrieve()
                .bodyToMono(ProductWrapper.class)
                .block();
    }

}
