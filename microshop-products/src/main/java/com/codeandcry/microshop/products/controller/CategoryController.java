package com.codeandcry.microshop.products.controller;

import com.codeandcry.microshop.products.dto.CategoryDTO;
import com.codeandcry.microshop.products.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RefreshScope
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/tree")
    public ResponseEntity<List<CategoryDTO>> getCategoryTree() {
        List<CategoryDTO> tree = categoryService.getCategoriesTree();
        return ResponseEntity.ok(tree);
    }
}
