package com.example.springsecuritymasterfilterdemo.controller;

import com.example.springsecuritymasterfilterdemo.dao.EmployeeDao;
import com.example.springsecuritymasterfilterdemo.entity.Employee;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeDao employeeDao;
    @GetMapping("list-employees")
    public String listEmployee(Model model){
        model.addAttribute("employees",employeeDao.findAll());
        return "employees";
    }
    @PostMapping("save-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "employeeForm";
        }
        employeeDao.save(employee);
        return "redirect:/employee/list-employees";
    }
    @GetMapping("/create-employee")
    public String createEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "employeeForm";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id")int id){
        employeeDao.deleteById(id);
        return "redirect:/employee/list-employees";
    }
}
