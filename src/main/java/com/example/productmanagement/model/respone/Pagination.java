package com.example.productmanagement.model.respone;

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
