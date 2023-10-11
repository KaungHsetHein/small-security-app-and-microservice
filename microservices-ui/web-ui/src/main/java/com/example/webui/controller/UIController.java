package com.example.webui.controller;

import com.example.webui.ds.Addresses;
import com.example.webui.ds.Employees;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web-ui")
public class UIController {
    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8080";
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/addresses")
    public String showAllAddress(Model model){
        var responseEntity=restTemplate
                .getForEntity(BASE_URL+"/address/list-addresses",
                        Addresses.class);
        model.addAttribute("addresses",
                responseEntity.getBody().getAddresses());
        return "index";
    }
    @GetMapping("/employees")
    public String showAllEmployees(Model model){
        var responseEntity = restTemplate
                .getForEntity(BASE_URL+"/employee/list-employees",
                Employees.class);
        model.addAttribute("employees",
                responseEntity.getBody().getEmployees());
        return "index";
    }


}












