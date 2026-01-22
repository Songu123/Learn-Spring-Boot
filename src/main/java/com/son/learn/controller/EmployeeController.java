package com.son.learn.controller;

import com.son.learn.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        System.out.println("\n [GET] /employees/add");
        System.out.println("Request to endpoint: /employees/add");

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        model.addAttribute("departments", getDepartmentMap());
        model.addAttribute("skills", getSkillsList());
        model.addAttribute("pageTitle", "Thêm Nhân Viên Mới");
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee, Model model) {
        System.out.println("\n [POST] /employees/add");
        System.out.println("Request to endpoint: /employees/add");
        System.out.println("Received Employee: " + employee);

        model.addAttribute("employee", employee);

        String departmentName = getDepartmentName(employee.getDepartment());
        model.addAttribute("departmentName", departmentName);

        model.addAttribute("pageTitle", "Kết Quả Thêm Nhân Viên");
        return "add-employee-result";
    }

    private Map<String, String> getDepartmentMap() {
        Map<String, String> departments = new LinkedHashMap<>();
        departments.put("IT", "Công Nghệ Thông Tin");
        departments.put("HR", "Nhân Sự");
        departments.put("SALES", "Kinh Doanh");
        departments.put("ACCOUNTING", "Kế Toán");
        departments.put("MARKETING", "Marketing");
        return departments;
    }

    private List<String> getSkillsList() {
        return Arrays.asList("Java", "C#", "Python", "JavaScript", "PHP", "Ruby");
    }

    private String getDepartmentName(String code) {
        return getDepartmentMap().getOrDefault(code, "Unknown Department");
    }

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
