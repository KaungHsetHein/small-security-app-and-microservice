package com.example.employeeservice.controller;

import com.example.employeeservice.dao.EmployeeDao;
import com.example.employeeservice.entity.Employees;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeDao employeeDao;
    @GetMapping("/list-employees")
    public Employees listAllEmployee(){
        return new Employees(employeeDao.findAll().spliterator());
    }
}
