package com.codeandcry.microshop.products.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
@RefreshScope
public class BrandController {

    @Value("${product.user.name}")
    private String username;
    @Value("${product.user.age}")
    private Integer userAge;

    @GetMapping("/list")
    public String getBrandList() {
        return username + " " + userAge;
    }
}
