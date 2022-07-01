package com.example.productmanagement.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
    private HttpStatus status;
    private String message;
}
