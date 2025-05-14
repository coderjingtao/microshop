package com.codeandcry.microshop.products.service;

import com.codeandcry.microshop.products.dto.CategoryDTO;
import com.codeandcry.microshop.products.entity.Category;
import com.codeandcry.microshop.products.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategoriesTree() {
        List<Category> allEntities = categoryRepository.findAll();

        List<CategoryDTO> allDTOs = allEntities.stream().map(CategoryDTO::fromEntity).toList();

        //构建parentCid -> children 对其所有下级分类的映射
        Map<Long, List<CategoryDTO>> parentMap = allDTOs.stream()
                .collect(Collectors.groupingBy(CategoryDTO::getParentCid));

        //构建树结构：parentCid = 0L 是顶级分类
        return parentMap.getOrDefault(0L, List.of()).stream()
                .sorted(Comparator.comparing(CategoryDTO::getSort))
                .peek(cat -> setChildren(cat, parentMap))
                .toList();
    }

    private void setChildren(CategoryDTO cat, Map<Long, List<CategoryDTO>> parentMap) {
        List<CategoryDTO> children = parentMap.getOrDefault(cat.getId(), List.of());
        if(!children.isEmpty()) {
            children.sort(Comparator.comparing(CategoryDTO::getSort));
            cat.setChildren(children);
            children.forEach(child -> setChildren(child, parentMap));
        }
    }
}
