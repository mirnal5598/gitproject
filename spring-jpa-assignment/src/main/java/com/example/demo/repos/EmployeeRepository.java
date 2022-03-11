package com.example.demo.repos;

import com.example.demo.entities.Employee_TTN;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee_TTN, Integer> {

    List<Employee_TTN> findByName(String name);
    List<Employee_TTN>findByNameLike(String name);
    List<Employee_TTN>findByAgeBetween(int age1, int age2);

}
