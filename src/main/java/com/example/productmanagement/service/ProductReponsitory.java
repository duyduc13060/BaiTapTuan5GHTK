package com.example.productmanagement.service;

import com.example.productmanagement.model.dto.ProductDto;
import com.example.productmanagement.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductReponsitory extends JpaRepository<com.example.productmanagement.service.ProductEntity,Long> {
//    api search product với điều kiện price > 50000, tên có chứa chữ ”áo”, có paging, sort giá giảm dần.
    @Query("SELECT p FROM ProductEntity p WHERE p.name LIKE ?1 AND p.price > 50000 ORDER BY p.price DESC")
    Page<com.example.productmanagement.service.ProductEntity> findBy(String name, Pageable pageable);


}
