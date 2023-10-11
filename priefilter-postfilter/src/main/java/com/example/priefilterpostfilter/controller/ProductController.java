package com.example.priefilterpostfilter.controller;

import com.example.priefilterpostfilter.ds.Product;
import com.example.priefilterpostfilter.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/sell")
    public List<Product> sellProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("beer","john"));
        products.add(new Product("candy","john"));
        products.add(new Product("chocolate","mary"));
        return service.sellProduct(products);
    }
    @GetMapping("/find")
    public List<Product> findProduct(){
        return service.findProduct();
    }
}
