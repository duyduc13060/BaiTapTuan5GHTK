package com.example.productmanagement.service;

import com.example.productmanagement.model.dto.WareHouseDto;
import com.example.productmanagement.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v2.0/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public ResponseEntity getAll(@RequestParam(value = "page") int page,
                                 @RequestParam(value = "page_size") int page_size){
        return ResponseEntity.ok(warehouseService.getAll(page,page_size));
    }

    @PostMapping
    public ResponseEntity create(
            @RequestParam(value = "distric_id") Long distric_id,
            @RequestParam(value = "province_id") Long province_id,
            @RequestBody WareHouseDto wareHouseDto
            ){
        return ResponseEntity.ok(warehouseService.create(wareHouseDto,distric_id,province_id));
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(warehouseService.delete(id));
    }

}
