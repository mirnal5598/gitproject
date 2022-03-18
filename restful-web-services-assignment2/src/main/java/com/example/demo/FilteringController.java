package com.example.demo;

import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployeeService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class FilteringController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/filter-employees")
    public MappingJacksonValue filterEmployees(){
        List<Employee> emp =employeeService.findAll();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "age", "name");
        FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(emp);
        mapping.setFilters(filters);
        return mapping;
    }

    //STATIC FILTERING
    @PostMapping("/static-filtering")
    public Employee createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return savedEmployee;
    }
    //DYNAMIC FILTERING
    @PostMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveSomeBean_dynamicFiltering(@RequestBody Employee employee){

        Employee savedEmployee = employeeService.saveEmployee(employee);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "age", "name");
        FilterProvider filters =  new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(savedEmployee);
        mapping.setFilters(filters);
        return mapping;
    }
}
