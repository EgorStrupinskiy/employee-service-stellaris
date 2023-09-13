package com.strupinski.employeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("employee")
public class Employee {

    @Id
    private String id;

    private String surname;

    private String name;

    private String secondName;

    private LocalDate birthDate;

    private int salary;

}
