package com.codeandcry.microshop.products.dto;

import com.codeandcry.microshop.products.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private Long parentCid;
    private Integer catLevel;
    private Byte showStatus;
    private Integer sort;
    private String icon;
    private String productUnit;
    private Integer productCount;
    private List<CategoryDTO> children = new ArrayList<>();

    public static CategoryDTO fromEntity(Category entity) {
        return new CategoryDTO(
                entity.getId(),
                entity.getName(),
                entity.getParentCid(),
                entity.getCatLevel(),
                entity.getShowStatus(),
                entity.getSort(),
                entity.getIcon(),
                entity.getProductUnit(),
                entity.getProductCount(),
                new ArrayList<>()
        );
    }
}


