package com.example.productmanagement.service;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super((message));
    }


}
