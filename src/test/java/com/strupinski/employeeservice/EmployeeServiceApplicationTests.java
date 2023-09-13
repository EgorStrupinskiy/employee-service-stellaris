package com.strupinski.employeeservice;

import com.strupinski.employeeservice.dto.EmployeeDTO;
import com.strupinski.employeeservice.dto.mapper.EmployeeMapper;
import com.strupinski.employeeservice.entity.Employee;
import com.strupinski.employeeservice.exception.NoSuchEmployeeException;
import com.strupinski.employeeservice.repository.EmployeeRepository;
import com.strupinski.employeeservice.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceApplicationTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private static EmployeeDTO employeeDTO;

    private static Employee entity;

    private static String id;

    @BeforeAll
    public static void init() {
        id = "6500d0dd3df92a172f0cebf3";

        employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        employeeDTO.setSurname("Ivanov");
        employeeDTO.setName("Maxim");
        employeeDTO.setSecondName("Olegovich");
        employeeDTO.setBirthDate(LocalDate.of(2002, 11, 1));
        employeeDTO.setSalary(10000);

        entity = new Employee();
        entity.setId(id);
        entity.setSurname("Ivanov");
        entity.setName("Maxim");
        entity.setSecondName("Olegovich");
        entity.setBirthDate(LocalDate.of(2002, 11, 1));
        entity.setSalary(10000);
    }

    @Test
    public void shouldFindEmployeeById() {
        when(employeeRepository.findById(id)).thenReturn(Optional.of(entity));

        EmployeeDTO actual = employeeService.findById(id);

        assertEquals(employeeDTO, actual);

        verify(employeeRepository, times(1)).findById(id);
    }

    @Test
    public void shouldGetEmptyList() {
        when(employeeRepository.findAll(Pageable.ofSize(10))).thenReturn(Page.empty());

        List<EmployeeDTO> actual = employeeService.getList(0, 10);

        assertEquals(List.of(), actual);

        verify(employeeRepository, times(1)).findAll(Pageable.ofSize(10));
    }

    @Test
    public void shouldGetListWithEmployee() {
        List<Employee> employees = List.of(entity);
        Pageable pageable = Pageable.ofSize(1);
        Page<Employee> employeePage = new PageImpl<>(employees, pageable, employees.size());

        when(employeeRepository.findAll(Pageable.ofSize(10))).thenReturn(employeePage);

        List<Employee> actual = employeeService.getList(0, 10).stream()
                .toList()
                .stream()
                .map(EmployeeMapper.INSTANCE::toEntity)
                .toList();

        assertEquals(employees, actual);

        verify(employeeRepository, times(1)).findAll(Pageable.ofSize(10));
    }

    @Test
    public void shouldThrowNotFoundIfIdIsIncorrect() {
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchEmployeeException.class, () -> employeeService.findById(id));

        verify(employeeRepository, times(1)).findById(id);
        verifyNoMoreInteractions(employeeRepository);
    }

    @Test
    public void shouldCorrectlyCreateNewEmployee() {
        when(employeeRepository.save(entity)).thenReturn(entity);

        EmployeeDTO actual = employeeService.save(employeeDTO);

        assertEquals(employeeDTO, actual);

        verify(employeeRepository, times(1)).save(entity);
    }
}
