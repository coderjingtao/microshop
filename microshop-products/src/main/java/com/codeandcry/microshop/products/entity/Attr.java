package com.codeandcry.microshop.products.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pms_attr")
public class Attr {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long attrId;
  private String attrName;
  private Long searchType;
  private Long valueType;
  private String icon;
  private String valueSelect;
  private Long attrType;
  private Long enable;
  private Long catelogId;
  private Long showDesc;
}
