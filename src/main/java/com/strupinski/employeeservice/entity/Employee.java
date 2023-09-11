package com.strupinski.employeeservice.entity;

import com.strupinski.employeeservice.model.FullName;
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

    private FullName fullName;

    private LocalDate birthDate;

    private int salary;

}
