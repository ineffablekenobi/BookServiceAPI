package com.ineffable.bookservice.Exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String str)
    {
        super(str);
    }
}
