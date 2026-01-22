package com.son.learn.controller;

import com.son.learn.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/single")
    public String getSingleEmployee(Model model) {
        System.out.println("\n [GET] /employees/single");
        System.out.println("Request to endpoint: /employees/single");

        Employee employee = new Employee(1, "Nguyen Van A", 12444444);

        model.addAttribute("employee", employee);

        model.addAttribute("pageTitle", "Thông Tin Nhân Viên");
        return "employee-single";
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        System.out.println("\n [GET] /employees/list");

        List<Employee> employees = createSampleEmployees();

        System.out.println("Request to endpoint: /employees/list");
        employees.forEach(employee -> System.out.println("  └─> " + employee));

        model.addAttribute("employees", employees);
        model.addAttribute("pageTitle", "Danh Sách Nhân Viên");
        model.addAttribute("totalEmployees", employees.size());

        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        model.addAttribute("totalSalary", totalSalary);

        double averageSalary = totalSalary / employees.size();
        model.addAttribute("averageSalary", averageSalary);

        return "employee-list";
    }


    private List<Employee> createSampleEmployees() {
        return List.of(new Employee(1, "Nguyen Van A", 12444444), new Employee(2, "Tran Thi B", 13455555), new Employee(3, "Le Van C", 14566666), new Employee(4, "Pham Thi D", 15677777));
    }

    @GetMapping
    public String employeeHome() {
        System.out.println("\n [GET] /employees");
        System.out.println("Request to endpoint: /employees");
        return "employee-home";
    }
}
