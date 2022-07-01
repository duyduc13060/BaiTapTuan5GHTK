package com.example.productmanagement.service;


import com.example.productmanagement.model.entity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductEntity> productEntities;


}
