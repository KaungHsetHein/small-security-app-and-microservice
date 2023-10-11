package com.example.webui.ds;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Data
public class Employees {
    private List<Employee> employees=
            new ArrayList<>();
    public Employees(){}
    public Employees(Spliterator<Employee> employeeSpliterator){
        employees = StreamSupport.stream(employeeSpliterator,false)
                .collect(Collectors.toList());
    }
}










