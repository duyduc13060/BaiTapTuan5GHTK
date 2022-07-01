package com.example.productmanagement.service;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String message;
}
