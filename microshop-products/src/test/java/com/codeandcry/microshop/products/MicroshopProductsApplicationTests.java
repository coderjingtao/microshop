package com.codeandcry.microshop.products;

import com.codeandcry.microshop.products.repository.AttrRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroshopProductsApplicationTests {

    @Autowired
    private AttrRepository attrRepository;

    @Test
    void contextLoads() {
        attrRepository.findAll().forEach(System.out::println);
    }

}
