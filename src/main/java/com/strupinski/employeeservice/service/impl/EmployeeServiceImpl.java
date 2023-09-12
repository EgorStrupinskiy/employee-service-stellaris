package com.strupinski.employeeservice.service.impl;

import com.strupinski.employeeservice.dto.EmployeeDTO;
import com.strupinski.employeeservice.dto.mapper.EmployeeMapper;
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
    public EmployeeDTO findById(String id) {
        return EmployeeMapper.INSTANCE.toDto(employeeRepository.findById(id).orElseThrow(() -> new NoSuchEmployeeException("There is no employee with id: " + id)));
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        return EmployeeMapper.INSTANCE.toDto(employeeRepository.save(EmployeeMapper.INSTANCE.toEntity(employee)));
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getList(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return employeeRepository.findAll(pageable)
                .stream()
                .map(EmployeeMapper.INSTANCE::toDto)
                .toList();
    }
}
