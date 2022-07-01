package com.example.productmanagement.service;

import com.example.productmanagement.model.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceReponsitory extends JpaRepository<ProvinceEntity,Long> {
}
