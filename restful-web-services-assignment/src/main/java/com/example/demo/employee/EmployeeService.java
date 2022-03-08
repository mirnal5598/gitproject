package com.example.demo.employee ;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {

   static List<Employee> employees = new ArrayList<>();
    private static int employeeCount=3;
    static {
        employees.add(new Employee(1, 23, "Adi"));
        employees.add(new Employee(2, 24, "Aashish"));
        employees.add(new Employee(3, 22, "Karan"));
    }

    public List<Employee> findAll(){
        return employees;
    }
    public Employee findOne(int id){
       for(Employee emp : employees) {
           if (emp.getId()==id){
               return emp;
           }
       }
       return null;
    }
    public Employee saveEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(++employeeCount);
        }
        employees.add(employee);
        return employee;
    }

    public Employee deleteById(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee emp = iterator.next();
            if(emp.getId()==id){
                iterator.remove();
                return emp;
            }
        }
        return null;
    }
}
