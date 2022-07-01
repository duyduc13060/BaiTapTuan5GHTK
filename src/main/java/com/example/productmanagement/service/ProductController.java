package com.example.productmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v2.0/product")
public class ProductController {

    @Autowired
    ProductReponsitory reponsitory;

    @Autowired
    ProductService productService;


//    @GetMapping("/search")
//    public ResponseEntity searchAndPage(
//            @RequestParam(value = "name") String name,
//            @RequestParam(value = "page") int page,
//            @RequestParam(value = "page_size") int page_size
//    ){
//        Pageable pageable = PageRequest.of(page,page_size);
//        return ResponseEntity.ok(reponsitory.findBy("%"+name+"%",pageable));
//    }
    ////////////////////////////////////////////

    @GetMapping
    public ResponseEntity findAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
    ){
        return ResponseEntity.ok(productService.getAll(page,page_size));
    }
    @GetMapping("/search")
    public ResponseEntity searchAndPage(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
    ){
        return ResponseEntity.ok(productService.searchName(name,page,page_size));
    }


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.create(productDto));
    }

//    @PostMapping
//    public ResponseEntity create(@Valid @RequestBody ProductDto productDto,
//                                 @RequestParam(value = "category_id") Long id){
//        return ResponseEntity.ok(productService.create(productDto,id));
//    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(productService.detele(id));
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.update(productDto));
    }


}
