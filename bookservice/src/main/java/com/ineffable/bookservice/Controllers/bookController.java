package com.ineffable.bookservice.Controllers;
import com.ineffable.bookservice.DTO.BookWrapper;
import com.ineffable.bookservice.Exceptions.BookNotFoundException;
import com.ineffable.bookservice.Models.Book;
import com.ineffable.bookservice.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public BookWrapper getBooks(){
        return new BookWrapper(bookService.getAll());
    }

    @GetMapping("/bookId={id}")
    public Book getBook(@PathVariable("id") Long id) throws BookNotFoundException {
        Optional<Book> book = bookService.getBook(id);
        if(book.isPresent()) {
            return book.get();
        }else {
            throw new BookNotFoundException("at Controller getBook()");
        }
    }

    @PostMapping("/add")
    public void createNewBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @RequestMapping("/delete/bookid={id}")
    public void deleteBook(@PathVariable("id") Long id) throws BookNotFoundException{
        bookService.removeBook(id);
    }

}
