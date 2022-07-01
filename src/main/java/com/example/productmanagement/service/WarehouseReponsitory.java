package com.example.productmanagement.service;

import com.example.productmanagement.model.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseReponsitory extends JpaRepository<WarehouseEntity,Long> {
}
