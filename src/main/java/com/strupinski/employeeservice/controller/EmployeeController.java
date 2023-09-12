package com.strupinski.employeeservice.controller;

import com.strupinski.employeeservice.entity.Employee;
import com.strupinski.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

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

    @GetMapping("/employees")
    public List<Employee> findEmployeePage(@Positive @RequestParam(name = "page") int page, @Positive @RequestParam(name = "pageSize") int pageSize) {
        return employeeService.getEmployeeList(page, pageSize);
    }
}
