package com.ineffable.bookshopgateway.Controllers;

import com.ineffable.bookshopgateway.DTO.BookWrapper;
import com.ineffable.bookshopgateway.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String url = "http://BOOK-SERVICE/books";


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
