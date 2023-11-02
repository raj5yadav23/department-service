package com.springboot.departmentservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department {

    private Long id;

    private String name;

    private List<Employee> employees=new ArrayList<Employee>();
}
