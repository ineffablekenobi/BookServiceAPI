package com.ineffable.bookservice.Services;
import com.ineffable.bookservice.Exceptions.BookNotFoundException;
import com.ineffable.bookservice.Models.Book;
import com.ineffable.bookservice.Repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAll(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBook(Long id) {
        Optional<Book> book =bookRepo.findById(id);
        return book;
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public void removeBook(Long id) throws BookNotFoundException {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }else{
            throw new BookNotFoundException("Remove book not found exception");
        }
    }

}

