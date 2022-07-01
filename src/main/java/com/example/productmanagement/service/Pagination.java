package com.example.productmanagement.service;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class Pagination {
    private Integer page;
    private Integer page_size;
    private Long total;
}
