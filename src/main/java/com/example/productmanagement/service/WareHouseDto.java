package com.example.productmanagement.service;

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
