package com.beidou.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    private String productDesc;

}
