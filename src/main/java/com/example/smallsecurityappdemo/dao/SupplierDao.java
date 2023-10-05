package com.example.smallsecurityappdemo.dao;

import com.example.smallsecurityappdemo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface SupplierDao extends JpaRepositoryImplementation<Supplier,Integer> {
    Optional<Supplier> findSupplierByName(String name);
}
