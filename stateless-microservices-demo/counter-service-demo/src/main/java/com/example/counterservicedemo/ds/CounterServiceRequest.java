package com.example.counterservicedemo.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CounterServiceRequest {
    int number;
    public CounterServiceRequest(@JsonProperty("number")int number){
        this.number=number;
    }

}
