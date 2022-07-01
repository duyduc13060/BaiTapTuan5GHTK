package com.example.productmanagement.service;

import com.example.productmanagement.exception.NotFoundException;
import com.example.productmanagement.model.dto.ProductDto;
import com.example.productmanagement.model.entity.CategoryEntity;
import com.example.productmanagement.model.entity.ProductEntity;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.model.respone.Pagination;
import com.example.productmanagement.model.respone.PaginationResponse;
import com.example.productmanagement.reponsitory.ProductReponsitory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductReponsitory productReponsitory;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PaginationResponse getAll(int page, int page_size){
        Page<ProductDto> productEntities =
                productReponsitory.findAll(PageRequest.of(page,page_size)).
                        map(productEntity -> modelMapper.map(productEntity,ProductDto.class));

        Pagination pagination = Pagination.builder().page(page).page_size(page_size)
                .total(productEntities.getTotalElements()).build();

        return PaginationResponse.builder().data(productEntities.getContent()).
                message("Thanh Cong").sattus(HttpStatus.OK.value()).pagination(pagination).build();
    }

    @Override
    public PaginationResponse searchName(String name, int page, int page_size){
        Pageable pageable = PageRequest.of(page,page_size);

        Page<ProductDto> productEntities = productReponsitory.findBy("%"+name+"%",pageable)
                .map(productEntity -> modelMapper.map(productEntity,ProductDto.class));

        Pagination pagination = Pagination.builder().page(page).page_size(page_size).
                                total(productEntities.getTotalElements()).build();

        return PaginationResponse.builder().data(productEntities.getContent()).
                message("Thanh Cong").sattus(HttpStatus.OK.value()).pagination(pagination).build();
    }

//    @Override
//    public ApiResponse create(ProductDto productDto, Long category_id){
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
//        String fomatDate = now.format(format);
//
//        ProductEntity productEntity = new ProductEntity();
//        CategoryEntity categoryEntity = categoryService.checkId(category_id);
//
//        productDto.setCreateAt(LocalDateTime.now());
//        productDto.setModifiedAt(LocalDateTime.now());
//        productDto.setCode(categoryEntity.getCode() +  "." + productDto.getSku() + "." + fomatDate);
//        productDto.setStatus(1);
//        productDto.setCategory(categoryEntity);
//
//        BeanUtils.copyProperties(productDto, productEntity);
//
//        productReponsitory.save(productEntity);
//
//        return ApiResponse.builder().message("Thanh Cong").
//                status(HttpStatus.OK.value()).data(productEntity).build();
//    }


    public ApiResponse create(ProductDto productDto) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String fomatDate = now.format(format);

        ProductEntity productEntity = new ProductEntity();
        CategoryEntity categoryEntity = categoryService.checkId(productDto.getCategory().getId());

        productDto.setCreateAt(LocalDateTime.now());
        productDto.setModifiedAt(LocalDateTime.now());
        productDto.setCode(categoryEntity.getCode() +  "." + productDto.getSku() + "." + fomatDate);
        productDto.setStatus(1);

        productDto.setCategory(categoryEntity);
        BeanUtils.copyProperties(productDto, productEntity);
        productReponsitory.save(productEntity);

        return ApiResponse.builder().message("Thanh Cong").
                status(HttpStatus.OK.value()).data(productEntity).build();
    }

    @Override
    public ApiResponse detele(Long id) {
        ProductEntity productEntity = checkId(id);

        productEntity.setStatus(0);

        productReponsitory.save(productEntity);

        return ApiResponse.builder().message("Thanh Cong").
                status(HttpStatus.OK.value()).data(productEntity).build();
    }

    @Override
    public ApiResponse update(ProductDto productDto) {
        ProductEntity oldProductEntity = checkId(productDto.getId());

        ProductEntity productEntity = new ProductEntity();
        CategoryEntity categoryEntity = categoryService.checkId(productDto.getCategory().getId());

        productDto.setCode(oldProductEntity.getCode());
        productDto.setCreateAt(oldProductEntity.getCreateAt());
        productDto.setModifiedAt(LocalDateTime.now());
        productDto.setStatus(oldProductEntity.getStatus());
        productDto.setCategory(categoryEntity);

        BeanUtils.copyProperties(productDto, productEntity);

        productReponsitory.save(productEntity);

        return ApiResponse.builder().message("Thanh cong").data(productEntity).
                status(HttpStatus.OK.value()).build();
    }

    public ProductEntity checkId(Long id) {
        Optional<ProductEntity> optional = productReponsitory.findById(id);
        if (optional.isPresent()) {
            return optional.orElse(null);
        }
        throw new NotFoundException("Id not found");
    }

}
