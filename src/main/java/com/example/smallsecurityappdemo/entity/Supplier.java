package com.example.smallsecurityappdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "supplier")
    private List<Product> products=new ArrayList<>();
    @ManyToMany(mappedBy = "suppliers",fetch = FetchType.EAGER)
    private Set<Role> roles=new HashSet<>();

    public void addProduct(Product product){
        product.setSupplier(this);
        products.add(product);
    }
    public void addRole(Role role){
        role.getSuppliers().add(this);
        roles.add(role);
    }

    public Supplier(String name, String password, String email, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
