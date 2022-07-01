package com.example.productmanagement.service;


import com.example.productmanagement.model.dto.CategoryDto;
import com.example.productmanagement.model.entity.CategoryEntity;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.model.respone.PaginationResponse;

import java.util.List;

public interface CategoryService {


    PaginationResponse findAll(int page, int page_size);

    ApiResponse create(CategoryDto categoryDto);

    ApiResponse delete(Long id);

    ApiResponse update(CategoryDto categoryDto);
}
