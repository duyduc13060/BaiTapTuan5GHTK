package com.example.productmanagement.service;

import com.example.productmanagement.exception.NotFoundException;
import com.example.productmanagement.model.entity.ProvinceEntity;
import com.example.productmanagement.reponsitory.ProvinceReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    ProvinceReponsitory provinceReponsitory;

    @Override
    public ProvinceEntity checkId(Long id){
        Optional<ProvinceEntity> optional = provinceReponsitory.findById(id);
        if(optional.isPresent()){
            return optional.orElse(null);
        }
        throw new NotFoundException("Id nt found");
    }
}
