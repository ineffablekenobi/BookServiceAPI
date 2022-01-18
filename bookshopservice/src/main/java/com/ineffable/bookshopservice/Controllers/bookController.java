package com.ineffable.bookshopservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ineffable.bookshopservice.Models.Book;
import com.ineffable.bookshopservice.DTO.BookWrapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String url = "http://localhost:8082/books";


    @GetMapping("/")
    public BookWrapper getBooks(){
        //BookWrapper wrapper = restTemplate.getForObject("http://BOOK-SERVICE/books/", BookWrapper.class);

        BookWrapper wrapper = webClientBuilder.build()
                    .get()
                    .uri(url +"/")
                    .retrieve()
                    .bodyToMono(BookWrapper.class)
                    .block();

        return wrapper;
    }

    @GetMapping("/bookId={id}")
    public Book getBook(@PathVariable("id") Long id) {
        Book book = webClientBuilder.build()
                .get()
                .uri(url +"/bookId="+id)
                .retrieve()
                .bodyToMono(Book.class)
                .block();
        return book;
    }

    @PostMapping("/add")
    public Book createNewBook(@RequestBody Book book){
         Book response = webClientBuilder.build().
                post().
                uri(url +"/add")
                .body(Mono.just(book), Book.class)
                .retrieve()
                .bodyToMono(Book.class)
                .block();
        return response;
    }


}
