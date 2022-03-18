package com.example.demo.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeService.findAll();
    }


    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    //HATEOS

    @GetMapping("/employees/{id}")
    public EntityModel<Employee> retrieveEmployee(@PathVariable int id){
        Employee emp = employeeService.findOne(id);
        if(emp==null){
            throw new EmployeeNotfoundException("id-"+id);
        }
        EntityModel<Employee> resource = EntityModel.of(emp);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllEmployees());

        resource.add(linkTo.withRel("all-employees"));

        return resource;
    }
}

