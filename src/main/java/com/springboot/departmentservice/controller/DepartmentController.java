package com.springboot.departmentservice.controller;

import com.springboot.departmentservice.model.Department;
import com.springboot.departmentservice.repository.DepartmentRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER= LoggerFactory
            .getLogger(DepartmentController.class);

    @Autowired
    public DepartmentRespository departmentRespository;

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("Department add: {}",department);
        Department department1=departmentRespository.addDepartment(department);
        return department1;
    }

    @GetMapping("/findAll")
    public List<Department> findAll(){
        return departmentRespository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Department findById(@PathVariable long id){
        Department department=departmentRespository.findById(id);
        return department;
    }
}
