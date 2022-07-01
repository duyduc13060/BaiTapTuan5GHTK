package com.example.productmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "sku")
    private String sku;

    @Column(name = "status")
    private Integer status;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
//    @JsonProperty
//    @RestControllerAdvice
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createAt;

    @Column(name = "modifile_at")
    private LocalDateTime modifiedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "productEntity")
    @JsonIgnore
    private List<WarehouseProductEntity> warehouseProductEntities;

}
