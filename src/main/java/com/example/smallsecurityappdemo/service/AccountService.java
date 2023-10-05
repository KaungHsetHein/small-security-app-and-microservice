package com.example.smallsecurityappdemo.service;

import com.example.smallsecurityappdemo.dao.RoleDao;
import com.example.smallsecurityappdemo.dao.SupplierDao;
import com.example.smallsecurityappdemo.entity.Role;
import com.example.smallsecurityappdemo.entity.Supplier;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final SupplierDao supplierDao;
    private final PasswordEncoder passwordEncoder;
    private final RoleDao roleDao;
    public void singUp(Supplier supplier){
        Role role=roleDao.findRoleByRoleName("ROLE_ADMIN")
                        .orElseThrow(EntityNotFoundException::new);
        supplier.addRole(role);
        supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
        supplierDao.save(supplier);
    }
}
