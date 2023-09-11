package com.strupinski.employeeservice.service.impl;

import com.strupinski.employeeservice.entity.Employee;
import com.strupinski.employeeservice.repository.EmployeeRepository;
import com.strupinski.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no employee with id: " + id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }
}
