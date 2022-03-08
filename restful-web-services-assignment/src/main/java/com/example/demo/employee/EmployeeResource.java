package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id){
        Employee emp = employeeService.findOne(id);
        if(emp==null){
            throw new EmployeeNotfoundException("id-"+id);
        }
        return emp;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee emp = employeeService.deleteById(id);
        if(emp==null){
            throw new EmployeeNotfoundException("id-"+id);
        }
        return emp;
    }
}
