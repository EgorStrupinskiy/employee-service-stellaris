package com.strupinski.employeeservice.controller;

import com.strupinski.employeeservice.entity.Employee;
import com.strupinski.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@Valid @PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@Valid @PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }
}
