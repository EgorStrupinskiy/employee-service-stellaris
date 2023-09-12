package com.strupinski.employeeservice.controller;

import com.strupinski.employeeservice.dto.EmployeeDTO;
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
    public EmployeeDTO findById(@Valid @PathVariable String id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public EmployeeDTO save(@Valid @RequestBody EmployeeDTO employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@Valid @PathVariable String id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> findByPage(@Positive @RequestParam(name = "page") int page, @Positive @RequestParam(name = "pageSize") int pageSize) {
        return employeeService.getList(page, pageSize);
    }
}
