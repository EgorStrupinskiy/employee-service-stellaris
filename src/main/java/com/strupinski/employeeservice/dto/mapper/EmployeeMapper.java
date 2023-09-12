package com.strupinski.employeeservice.dto.mapper;

import com.strupinski.employeeservice.dto.EmployeeDTO;
import com.strupinski.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDto(Employee employee);
    Employee toEntity(EmployeeDTO dto);
}
