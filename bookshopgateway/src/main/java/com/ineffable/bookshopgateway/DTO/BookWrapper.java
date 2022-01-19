package com.ineffable.bookshopgateway.DTO;

import com.ineffable.bookshopgateway.Models.Book;

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
