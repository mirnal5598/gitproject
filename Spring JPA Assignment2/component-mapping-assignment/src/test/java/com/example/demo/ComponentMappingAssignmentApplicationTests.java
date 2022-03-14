package com.example.demo;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Salary;
import com.example.demo.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentMappingAssignmentApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void testCreate() {
		Employee employee = new Employee();
		employee.setId(123);
		employee.setFirstName("Ramesh");
		employee.setLastName("Kumar");
		employee.setAge(32);

		Salary salary = new Salary();
		salary.setBasicSalary(55000);
		salary.setBonusSalary(11000);
		salary.setTaxAmount(10000);
		salary.setSpecialAllowanceSalary(25000);
		employee.setSalary(salary);
		repository.save(employee);
	}

}
