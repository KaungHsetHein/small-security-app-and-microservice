package com.example.smallsecurityappdemo.dao;

import com.example.smallsecurityappdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
