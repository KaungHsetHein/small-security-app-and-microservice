package com.example.springsecuritymasterfilterdemo.controller;

import com.example.springsecuritymasterfilterdemo.dao.CustomerDao;
import com.example.springsecuritymasterfilterdemo.entity.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;
    @Secured("ROLE_SUPER_ADMIN")
    @GetMapping("/list-customers")
    public String ListAllCustomers(Model model){
        model.addAttribute("customers",customerDao.findAll());
        return "customers";
    }
    @Secured("ROLE_SUPER_ADMIN")
    @GetMapping("/create-customer")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }
    @Secured("ROLE_SUPER_ADMIN")
    @PostMapping("/save-customer")
    public String processCustomer(@Valid Customer customer, BindingResult result){
       if (result.hasErrors()){
           return "customerForm";
       }
       customerDao.save(customer);
       return "redirect:/customer/list-customers";
    }
    @Secured("ROLE_SUPER_ADMIN")
    @GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam("id")int id){
        customerDao.deleteById(id);
        return "redirect:/customer/list-customers";
    }
}
