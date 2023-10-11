package com.example.counterservicedemo.controller;

import com.example.counterservicedemo.ds.CounterServiceResponse;
import com.example.counterservicedemo.service.MutableCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/counter/stateful")
public class StatefulCounterController {
    private final MutableCounter mutableCounter;
    @PostMapping("/countUp")
    public CounterServiceResponse countUp(){
        mutableCounter.countUp();
        return new CounterServiceResponse(mutableCounter.getNumber());
    }
}
