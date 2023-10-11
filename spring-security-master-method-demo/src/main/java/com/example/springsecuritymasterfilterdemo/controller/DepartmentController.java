package com.example.springsecuritymasterfilterdemo.controller;

import com.example.springsecuritymasterfilterdemo.dao.DepartmentDao;
import com.example.springsecuritymasterfilterdemo.entity.Department;
import jakarta.annotation.security.RolesAllowed;
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
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentDao departmentDao;
    @RolesAllowed({"SUPER_ADMIN","DEPAERTMENT_READ","DEPARTMENT_WRITE"})
    @RequestMapping("/list-departments")
    public String listDepartment(Model model){
        model.addAttribute("departments",departmentDao.findAll());
        return "departments";
    }
    @GetMapping("/create-department")
    public String createDepartment(Model model){
        model.addAttribute("department",new Department());
        return "departmentForm";
    }
    @PostMapping("save-department")
    public String saveDepartment(@Valid Department department, BindingResult result){
        if (result.hasErrors()){
            return "departmentForm";
        }
        departmentDao.save(department);
        return "redirect:/list-departments";
    }
    @GetMapping("/delete")
    public String deleteDepartment(@RequestParam("id")int id){
        departmentDao.deleteById(id);
        return "redirect:/list-departments";
    }
}
