package com.strupinski.employeeservice.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Document("employee")
public class Employee {

    @Id
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
