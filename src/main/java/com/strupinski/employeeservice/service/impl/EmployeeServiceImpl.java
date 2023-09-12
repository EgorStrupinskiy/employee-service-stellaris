package com.strupinski.employeeservice.service.impl;

import com.strupinski.employeeservice.entity.Employee;
import com.strupinski.employeeservice.exception.NoSuchEmployeeException;
import com.strupinski.employeeservice.repository.EmployeeRepository;
import com.strupinski.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public Employee findEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchEmployeeException("There is no employee with id: " + id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeeList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return employeeRepository.findAll(pageable).toList();
    }
}
