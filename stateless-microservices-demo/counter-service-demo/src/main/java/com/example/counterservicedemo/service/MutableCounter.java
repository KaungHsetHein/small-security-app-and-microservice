package com.example.counterservicedemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class MutableCounter {
    int number;
    public void countUp(){
        number ++;
    }
    public int getNumber(){
        return number;
    }
}
