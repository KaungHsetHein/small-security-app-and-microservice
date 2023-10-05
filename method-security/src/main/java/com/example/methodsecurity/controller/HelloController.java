package com.example.methodsecurity.controller;

import com.example.methodsecurity.ds.Employee;
import com.example.methodsecurity.service.BookService;
import com.example.methodsecurity.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final NameService nameService;

    private final BookService bookService;

    public HelloController(NameService nameService, BookService bookService) {
        this.nameService = nameService;
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String hello(){
        return nameService.getName();
    }

    @GetMapping("/secret/{name}")
    public List<String> secretName(@PathVariable("name")String name){
        return nameService.getSecretName(name);
    }
    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable("name")String name){
        return bookService.getBookDetails(name);
    }

}
