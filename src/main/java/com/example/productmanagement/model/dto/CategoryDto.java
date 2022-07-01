package com.example.productmanagement.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CategoryDto {

    private Long id;

    @Length(max = 100 , message = "Ten phai < 100 ky tu")
    private String name;

    private String code;

    private Integer status;

    private String description;

}
