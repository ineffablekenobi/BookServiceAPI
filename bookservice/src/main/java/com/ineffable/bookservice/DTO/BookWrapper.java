package com.ineffable.bookservice.DTO;

import com.ineffable.bookservice.Models.Book;

import java.util.List;

public class BookWrapper {
    private List<Book> bookList;

    public BookWrapper(List<Book> bookList) {
        this.bookList = bookList;
    }

    public BookWrapper() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
