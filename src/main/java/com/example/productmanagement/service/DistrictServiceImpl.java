package com.example.productmanagement.service;

import com.example.productmanagement.exception.NotFoundException;
import com.example.productmanagement.model.entity.DistrictEntity;
import com.example.productmanagement.reponsitory.DistrictReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    DistrictReponsitory districtReponsitory;

    @Override
    public DistrictEntity checkId(Long id){
        Optional<DistrictEntity> optional = districtReponsitory.findById(id);
        if(optional.isPresent()){
            return optional.orElse(null);
        }
        throw new NotFoundException("Id not found");
    }

}
