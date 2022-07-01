package com.example.productmanagement.controller;

import com.example.productmanagement.model.dto.CategoryDto;
import com.example.productmanagement.model.entity.CategoryEntity;
import com.example.productmanagement.model.respone.ApiResponse;
import com.example.productmanagement.reponsitory.CategoryReponsitory;
import com.example.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2.0/category")
public class CategoryController {

    @Autowired
    CategoryReponsitory reponsitory;

    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public ResponseEntity get(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size){

        return ResponseEntity.ok(categoryService.findAll(page,page_size));
    }

    @PostMapping()
    public ResponseEntity create
            (
                    @RequestBody CategoryDto categoryDto
            ) {
        return ResponseEntity.ok(categoryService.create(categoryDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete
            (
                    @PathVariable Long id
            ) {
        return ResponseEntity.ok(categoryService.delete(id));
    }

    @PutMapping()
    public ResponseEntity update
            (
                    @RequestBody CategoryDto categoryDto
            ) {
        return ResponseEntity.ok(categoryService.update(categoryDto));
    }


}
