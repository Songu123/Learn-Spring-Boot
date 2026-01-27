package com.son.learn.service.impl;

import com.son.learn.model.Employee;
import com.son.learn.repository.EmployeeRepository;
import com.son.learn.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy employee"));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
