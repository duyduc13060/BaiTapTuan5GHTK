package com.example.productmanagement.service;

import com.example.productmanagement.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryReponsitory extends JpaRepository<CategoryEntity,Long> {

}
