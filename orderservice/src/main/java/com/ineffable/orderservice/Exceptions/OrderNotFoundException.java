package com.ineffable.orderservice.Exceptions;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String str){
        super(str);
    }
}
