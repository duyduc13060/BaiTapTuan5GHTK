package com.example.productmanagement.service;

import com.example.productmanagement.model.dto.ProductDto;
import com.example.productmanagement.model.entity.ProductEntity;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.model.respone.PaginationResponse;

public interface ProductService {

    PaginationResponse getAll(int page, int page_size);

    PaginationResponse searchName(String name, int page, int page_size);

//    ApiResponse create(ProductDto productDto, Long category_id);
    ApiResponse create(ProductDto productDto);

    ApiResponse detele(Long id);

    ApiResponse update(ProductDto productDto);


}
