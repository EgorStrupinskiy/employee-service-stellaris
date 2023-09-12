package com.strupinski.employeeservice;

import com.strupinski.employeeservice.dto.EmployeeDTO;
import com.strupinski.employeeservice.dto.mapper.EmployeeMapper;
import com.strupinski.employeeservice.exception.NoSuchEmployeeException;
import com.strupinski.employeeservice.repository.EmployeeRepository;
import com.strupinski.employeeservice.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeServiceApplicationTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private static EmployeeDTO employeeDTO;
    private static String id;

    @BeforeAll
    public static void init(){
        id = "6500d0dd3df92a172f0cebf3";
        employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        employeeDTO.setSurname("Ivanov");
        employeeDTO.setName("Maxim");
        employeeDTO.setSecondName("Olegovich");
        employeeDTO.setBirthDate(LocalDate.of(2002, 11, 1));
        employeeDTO.setSalary(10000);
    }

    @Test
    public void shouldFindEmployeeById() {
        when(employeeRepository.findById(id)).thenReturn(Optional.of(EmployeeMapper.INSTANCE.toEntity(employeeDTO)));

        EmployeeDTO actual = employeeService.findById(id);

        assertEquals(employeeDTO, actual);
    }

    @Test
    public void shouldThrowNotFoundIfIdIsIncorrect() {
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchEmployeeException.class, () -> employeeService.findById(id));
    }
}
