package com.example.productmanagement.service;

import com.example.productmanagement.exception.NotFoundException;
import com.example.productmanagement.model.dto.CategoryDto;
import com.example.productmanagement.model.entity.CategoryEntity;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.model.respone.Pagination;
import com.example.productmanagement.model.respone.PaginationResponse;
import com.example.productmanagement.reponsitory.CategoryReponsitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryReponsitory categoryReponsitory;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PaginationResponse findAll(int page, int page_size){
        Page<CategoryDto> categoryDtos = categoryReponsitory.findAll(PageRequest.of(page,page_size))
                .map(categoryEntity -> modelMapper.map(categoryEntity,CategoryDto.class));

        Pagination pagination =
                Pagination.builder().page(page).page_size(page_size).
                total(categoryDtos.getTotalElements()).build();

        return PaginationResponse.builder().data(categoryDtos.getContent()).message("Thanh cong").sattus(HttpStatus.OK.value())
                .pagination(pagination).build();
    }

    @Override
    public ApiResponse create(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryDto.setStatus(1);
        BeanUtils.copyProperties(categoryDto, categoryEntity);

        categoryReponsitory.save(categoryEntity);
        return ApiResponse.builder().status(HttpStatus.OK.value()).message("Thanh Cong").data(categoryEntity).build();
    }

    @Override
    public ApiResponse delete(Long id) {
        CategoryEntity categoryEntity = checkId(id);
        categoryEntity.setStatus(0);

        categoryReponsitory.save(categoryEntity);

        return ApiResponse.builder().status(HttpStatus.OK.value()).message("Thanh Cong").data(categoryEntity).build();
    }

    @Override
    public ApiResponse update(CategoryDto categoryDto) {
        CategoryEntity oldCategoryEntity = checkId(categoryDto.getId());

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryDto.setStatus(oldCategoryEntity.getStatus());

        BeanUtils.copyProperties(categoryDto, categoryEntity);

        categoryReponsitory.save(categoryEntity);

        return ApiResponse.builder().status(HttpStatus.OK.value()).message("Thanh Cong").data(categoryEntity).build();
    }

    public CategoryEntity checkId(Long id) {
        Optional<CategoryEntity> optional = categoryReponsitory.findById(id);
        if (optional.isPresent()) {
            return optional.orElse(null);
        }
        throw new NotFoundException("Id not found !");
    }

}
