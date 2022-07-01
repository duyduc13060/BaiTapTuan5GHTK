package com.example.productmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "warehouseProduct")
public class WarehouseProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "totalImport")
    private Integer totalImport;

    @Column(name = "totalExport")
    private Integer totalExport;

    @Column(name = "startDate")
    private Integer startDate;

    @Column(name = "expiredDate")
    private Integer expiredDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;
}
