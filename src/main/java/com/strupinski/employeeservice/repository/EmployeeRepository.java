package com.strupinski.employeeservice.repository;

import com.strupinski.employeeservice.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Page<Employee> findAll(Pageable pageable);
}
