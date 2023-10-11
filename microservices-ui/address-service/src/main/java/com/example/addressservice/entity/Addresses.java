package com.example.addressservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@ToString
public class Addresses {
    private List<Address> addresses=
            new ArrayList<>();
    public Addresses(Spliterator<Address> spliterator){
        addresses=StreamSupport.stream(spliterator,false)
                .collect(Collectors.toList());
    }

}
