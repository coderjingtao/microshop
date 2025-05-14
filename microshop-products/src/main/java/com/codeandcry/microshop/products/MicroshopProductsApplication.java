package com.codeandcry.microshop.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroshopProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroshopProductsApplication.class, args);
    }

}
