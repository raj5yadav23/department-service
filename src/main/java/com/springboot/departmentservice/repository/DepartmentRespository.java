package com.springboot.departmentservice.repository;

import com.springboot.departmentservice.model.Department;
import com.springboot.departmentservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRespository {

    public List<Department> departments=new ArrayList<Department>();

    @Autowired
    public RestTemplate restTemplate;

    public Department addDepartment(Department department){
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(department-> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        List<Department> departmentList=new ArrayList<>();
        for(Department department:departments){
            List<Employee> empList=restTemplate.getForObject("http://localhost:8082/employee/department/"+department.getId()
            ,List.class);
            department.setEmployees(empList);
            departmentList.add(department);
        }
        return departmentList;
    }
}
