package com.strupinski.employeeservice.service;

import com.strupinski.employeeservice.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO findById(String id);


    EmployeeDTO save(EmployeeDTO employee);


    void deleteById(String id);

    List<EmployeeDTO> getList(int page, int pageSize);
}
