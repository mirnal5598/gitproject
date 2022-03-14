package com.example.demo.repos;

import com.example.demo.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("from Employee")
    List<Employee> findAllEmployees();
    @Query("select avg(salary) from Employee")
    double findAvgSalary();
    @Query("select e.firstName, e.lastName, e.salary from Employee e where e.salary>(select AVG(salary) from Employee)")
    List<Object[]> findAllEmployeesAvg(Sort sort);
    @Modifying
    @Query("update Employee set salary =:salary where salary< :avgSalary")
    void updateSalary(@Param("salary")double salary, @Param("avgSalary")double avgSalary);
    @Query("select min(salary) from Employee")
    double findMinimumSalary();
    @Modifying
    @Query("delete from Employee where salary=:minSalary")
    void deleteEmployee(@Param("minSalary") double minSalary);

    @Query(value = "select * from employee where lastname like '%Singh'", nativeQuery = true)
    List<Object[]> findByNQ();
    @Modifying
    @Query(value = "delete from employee where empAge>:age" , nativeQuery = true)
    void deleteEmployeeNQ(@Param("age") int age);
}
