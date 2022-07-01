package com.example.productmanagement.model.entity;

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
@Table(name = "warehouse")
public class WarehouseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonIgnore
    private DistrictEntity district;

    @ManyToOne
    @JoinColumn(name = "province_id")
    @JsonIgnore
    private ProvinceEntity province;

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    private List<WarehouseProductEntity> warehouseProductEntities;

}
