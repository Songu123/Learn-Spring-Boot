package com.son.learn.controller;

import com.son.learn.model.Employee;
import com.son.learn.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Inject service to replace mock data operations
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = service.findAll();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id,
                               @Valid @ModelAttribute("employee") Employee employee,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/employees";
    }
}
