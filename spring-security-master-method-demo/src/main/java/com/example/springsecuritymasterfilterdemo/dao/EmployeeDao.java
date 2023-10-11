package com.example.springsecuritymasterfilterdemo.dao;

import com.example.springsecuritymasterfilterdemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
