package com.ineffable.bookservice.Repositories;

import com.ineffable.bookservice.Models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Long> {
    public List<Book> findAll();
}
