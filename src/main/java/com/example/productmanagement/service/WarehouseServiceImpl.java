package com.example.productmanagement.service;

import com.example.productmanagement.exception.NotFoundException;
import com.example.productmanagement.model.dto.WareHouseDto;
import com.example.productmanagement.model.entity.DistrictEntity;
import com.example.productmanagement.model.entity.ProvinceEntity;
import com.example.productmanagement.model.entity.WarehouseEntity;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.model.respone.Pagination;
import com.example.productmanagement.model.respone.PaginationResponse;
import com.example.productmanagement.reponsitory.WarehouseReponsitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    @Autowired
    WarehouseReponsitory warehouseReponsitory;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public PaginationResponse getAll(int page, int page_size){
        Page<WareHouseDto> warehouseEntities = warehouseReponsitory.findAll(PageRequest.of(page,page_size))
                .map(warehouseEntity -> modelMapper.map(warehouseEntity,WareHouseDto.class));

        Pagination pagination = Pagination.builder().page(page).page_size(page_size).
                total(warehouseEntities.getTotalElements()).build();

        return PaginationResponse.builder().sattus(HttpStatus.OK.value()).
                message("Thanh Cong").data(warehouseEntities.getContent()).pagination(pagination).build();
    }

    @Override
    public ApiResponse create(WareHouseDto wareHouseDto, Long district_id, Long province_id){

        WarehouseEntity warehouseEntity = new WarehouseEntity();

        ProvinceEntity productEntity = provinceService.checkId(district_id);
        DistrictEntity districtEntity = districtService.checkId(province_id);

        wareHouseDto.setStatus(1);
        wareHouseDto.setDistrict(districtEntity);
        wareHouseDto.setProvince(productEntity);
        wareHouseDto.setAddress(wareHouseDto.getAddress()+","+ districtEntity.getName() + "," + productEntity.getName());

        BeanUtils.copyProperties(wareHouseDto,warehouseEntity);

        warehouseReponsitory.save(warehouseEntity);

        return ApiResponse.builder().status(HttpStatus.OK.value()).message("Thanh Cong")
                .data(warehouseEntity).build();
    }

    @Override
    public ApiResponse delete(Long id){
        WarehouseEntity warehouseEntity = checkId(id);
        warehouseEntity.setStatus(0);
        warehouseReponsitory.save(warehouseEntity);
        return ApiResponse.builder().status(HttpStatus.OK.value()).message("Thanh Cong").
                data(warehouseEntity).build();
    }

    public WarehouseEntity checkId(Long id){
        Optional<WarehouseEntity> optional = warehouseReponsitory.findById(id);
        if(optional.isPresent()){
            return optional.orElse(null);
        }
        throw new NotFoundException("Id not found");
    }


}
