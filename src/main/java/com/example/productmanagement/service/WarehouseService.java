package com.example.productmanagement.service;

import com.example.productmanagement.model.dto.WareHouseDto;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.model.respone.PaginationResponse;

public interface WarehouseService {
    PaginationResponse getAll(int page, int page_size);

    ApiResponse create(WareHouseDto wareHouseDto, Long district_id, Long province_id);

    ApiResponse delete(Long id);
}
