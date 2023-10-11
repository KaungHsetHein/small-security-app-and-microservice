package com.example.springsecuritymasterfilterdemo.dao;

import com.example.springsecuritymasterfilterdemo.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department,Integer> {
}
