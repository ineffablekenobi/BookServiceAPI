package com.ineffable.bookshopservice.Controllers;

import org.springframework.web.bind.annotation.*;
import com.ineffable.bookshopservice.Models.Book;
import com.ineffable.bookshopservice.DTO.BookWrapper;

@RestController
@RequestMapping("/books")
public class bookController {



    @GetMapping("/")
    public BookWrapper getBooks(){

    }

    @GetMapping("/bookId={id}")
    public Book getBook(@PathVariable("id") Long id) {

    }

    @PostMapping("/add")
    public void createNewBook(@RequestBody Book book){

    }

    @RequestMapping("/delete/bookid={id}")
    public void deleteBook(@PathVariable("id") Long id) {

    }

}
