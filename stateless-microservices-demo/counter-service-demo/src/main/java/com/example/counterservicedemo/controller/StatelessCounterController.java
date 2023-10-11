package com.example.counterservicedemo.controller;

import com.example.counterservicedemo.ds.CounterServiceRequest;
import com.example.counterservicedemo.ds.CounterServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/counter/stateless")
public class StatelessCounterController {
    @PostMapping("/countUp")
    public CounterServiceResponse countUp(@RequestBody CounterServiceRequest request){
        return new CounterServiceResponse(request.getNumber() + 1);
    }
}
