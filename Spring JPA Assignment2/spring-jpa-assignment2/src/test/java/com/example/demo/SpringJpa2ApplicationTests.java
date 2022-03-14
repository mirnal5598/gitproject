package com.example.demo;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class SpringJpa2ApplicationTests {
@Autowired
	EmployeeRepository repository;

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Rajeev");
		employee.setLastName("Thakkar");
		employee.setAge(48);
		employee.setSalary(75000);

		Employee employee1 = new Employee();
		employee1.setFirstName("Aman");
		employee1.setLastName("Singh");
		employee1.setAge(29);
		employee1.setSalary(95000);
		repository.save(employee);
		repository.save(employee1);
	}
	@Test
	public void findAllEmployees(){
		System.out.println(repository.findAllEmployees());
	}
	@Test
	public void findAvgSalary(){
		System.out.println(repository.findAvgSalary());
	}
	@Test
	public void findSalaryGreaterThanAvgSalary(){
		Sort sort = Sort.by("age").ascending().and(Sort.by("salary").descending());
		List<Object[]> list= repository.findAllEmployeesAvg(sort);
		for(Object[] object : list) {
			System.out.println(object[0]+" "+object[1]+" "+object[2]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void updateSalaryLessThanAvgSalary(){
		double avgSalary=repository.findAvgSalary();
		repository.updateSalary(99000,avgSalary);

	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void deleteEmployee(){
		double minSalary=repository.findMinimumSalary();
		repository.deleteEmployee(minSalary);
	}

	@Test
	public void findByNQ(){
		List<Object[]> employee = repository.findByNQ();
		for(Object[] obj : employee){
			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void deleteByNQ(){
		repository.deleteEmployeeNQ(45);
	}


}
