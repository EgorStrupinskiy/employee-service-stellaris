package com.strupinski.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FullName {

    private String surname;

    private String name;

    private String secondName;

}
