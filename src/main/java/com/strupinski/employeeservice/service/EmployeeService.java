package com.strupinski.employeeservice.service;

import com.strupinski.employeeservice.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface EmployeeService {

    Employee findEmployeeById(@PathVariable String id);


    Employee saveEmployee(@RequestBody Employee employee);


    void deleteEmployeeById(@PathVariable String id);

    List<Employee> getEmployeeList(int page, int pageSize);
}
