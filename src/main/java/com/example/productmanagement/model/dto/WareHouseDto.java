package com.example.productmanagement.model.dto;

import com.example.productmanagement.model.entity.DistrictEntity;
import com.example.productmanagement.model.entity.ProvinceEntity;
import lombok.Data;

@Data
public class WareHouseDto {

    private Long id;
    private String name;
    private String address;
    private Integer status;
    private DistrictEntity district;
    private ProvinceEntity province;
}
