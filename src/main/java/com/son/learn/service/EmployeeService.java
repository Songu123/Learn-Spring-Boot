package com.son.learn.service;

import com.son.learn.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
    Employee findById(int id);
    void deleteById(int id);
}
