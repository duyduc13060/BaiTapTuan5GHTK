package com.example.productmanagement.model.respone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationResponse {
    private String message;
    private Integer sattus;
    private Object data;
    private Pagination pagination;
}
