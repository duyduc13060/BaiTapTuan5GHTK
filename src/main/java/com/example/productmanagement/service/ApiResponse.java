package com.example.productmanagement.service;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {
    private String message;
    private Integer status;
    private Object data;
}
