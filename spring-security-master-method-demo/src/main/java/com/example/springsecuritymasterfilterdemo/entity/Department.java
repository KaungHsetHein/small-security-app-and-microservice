package com.example.springsecuritymasterfilterdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 2,max = 5,
    message = "code must have length 2 -5 characters.")
    @Pattern(regexp = "[A-Za-z]*",message = "Code cannot contain illegal numbers.")
    private String code;
    @NotBlank
    @Pattern(regexp = "[A-Za-z ]*",message = "Name cannot contain illegal numbers. ")
    private String name;
    @NotBlank
    @Pattern(regexp = "[A-Za-z ]*",message = "Country cannot contain illegal numbers. ")
    private String country;

}
