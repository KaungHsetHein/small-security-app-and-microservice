package com.example.smallsecurityappdemo.controller;

import com.example.smallsecurityappdemo.entity.Supplier;
import com.example.smallsecurityappdemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/signup")
    public String singUp(Model model){
        model.addAttribute("supplier",new Supplier());
        return "signup";
    }
    @PostMapping("/save")
    public String saveSupplier(Supplier supplier, BindingResult result){
        if (result.hasErrors()){
            return "signup";
        }
        accountService.singUp(supplier);
        System.out.println(supplier.getName());
        System.out.println(supplier.getPassword());
        System.out.println(supplier.getPhoneNumber());
        System.out.println(supplier.getEmail());
        return "redirect:/login";
    }
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
}

