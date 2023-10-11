package com.example.priefilterpostfilter.service;

import com.example.priefilterpostfilter.ds.Product;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    @PreFilter("filterObject.owner == authentication.name")
    public List<Product> sellProduct(List<Product> products){
        return products;
    }

    @PostFilter("filterObject.owner == authentication.name")
    public List<Product> findProduct(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("beer","john"));
        products.add(new Product("candy","john"));
        products.add(new Product("chocolate","mary"));
        return products;

    }
}
