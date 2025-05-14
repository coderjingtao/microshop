package com.codeandcry.microshop.products.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pms_category", schema = "microshop_pms")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "parent_cid")
    private Long parentCid;

    @Column(name = "cat_level")
    private Integer catLevel;

    @Column(name = "show_status")
    private Byte showStatus;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "icon")
    private String icon;

    @Column(name = "product_unit", length = 50)
    private String productUnit;

    @Column(name = "product_count")
    private Integer productCount;

    @Transient
    private List<Category> children;

}