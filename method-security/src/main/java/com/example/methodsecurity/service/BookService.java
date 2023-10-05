package com.example.methodsecurity.service;

import com.example.methodsecurity.ds.Employee;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Employee> records = Map.of("john",new Employee("John Doe", List.of("Karamazov Brother"),
            List.of("accountant","write")),
            "mary",new Employee("mary soe",List.of("Beautiful Paris"),List.of("researcher")));
    @PostAuthorize("#returnObject.books.contains('Karamazov Brother')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}


