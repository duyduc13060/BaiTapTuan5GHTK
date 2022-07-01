package com.example.productmanagement.service;

import com.example.productmanagement.model.entity.WarehouseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "district")
public class DistrictEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private List<WarehouseEntity> wareHouseList;
}


