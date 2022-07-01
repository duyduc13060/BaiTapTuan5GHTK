package com.example.productmanagement.service;

import com.example.productmanagement.exception.ErrorResponse;
import com.example.productmanagement.exception.NotFoundException;
import com.example.productmanagement.model.respone.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(com.example.productmanagement.exception.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public com.example.productmanagement.exception.ErrorResponse handlerNotFoundException(NotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }

//    @ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ApiResponse handleExceptionObject(Exception e){
//        return ApiResponse.builder().status(HttpStatus.OK.value()).message(e.getMessage()).data(null).build();
//    }

}
