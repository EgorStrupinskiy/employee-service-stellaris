package com.strupinski.employeeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private String id;

    @NotBlank(message = "Surname can`t be empty")
    private String surname;

    @NotBlank(message = "Name can`t be empty")
    private String name;

    @NotBlank(message = "SecondName can`t be empty")
    private String secondName;

    @PastOrPresent(message = "Enter correct birthdate")
    private LocalDate birthDate;

    @Positive(message = "Salary value must be positive")
    private int salary;
}
