package com.example.counterservicedemo.ds;

import lombok.Getter;

@Getter
public class CounterServiceResponse {
    private int number;

    public CounterServiceResponse(int number) {
        this.number = number;
    }
}
