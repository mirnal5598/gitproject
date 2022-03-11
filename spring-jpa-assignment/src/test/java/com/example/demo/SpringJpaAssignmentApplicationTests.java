package com.example.demo;

import com.example.demo.entities.Employee_TTN;
import com.example.demo.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringJpaAssignmentApplicationTests {

	@Autowired
	EmployeeRepository repository;
	@Test
	public void createEmployee() {
		Employee_TTN employee = new Employee_TTN();
		employee.setId(6);
		employee.setName("Rahul");
		employee.setAge(29);
		employee.setLocation("Delhi");
		repository.save(employee);

	}
	@Test
	public void testUpdate(){
		Employee_TTN employee = repository.findById(1).get();
		employee.setAge(24);
		repository.save(employee);
	}
	@Test
	public void testDelete(){
		if(repository.existsById(1)){
			repository.deleteById(1);
		}
	}
	@Test
	public void testRead(){
		Employee_TTN employee = repository.findById(2).get();
		assertNotNull(employee);
		assertEquals("Ajay", employee.getName());
		System.out.println(employee.getName()+">>>>>>>>>>>>>>>>>>>>>>>>"+employee.getAge());
	}

	@Test
	public void testCount(){
		System.out.println("Total records--------------------> "+repository.count());
	}

	@Test
	public void testFindByName(){
		List<Employee_TTN> list = repository.findByName("Ajay");
		list.forEach(e-> System.out.println(e.getName()));
	}
	@Test
	public void testFindByNameLike(){
		List<Employee_TTN> list = repository.findByNameLike("A%");
		list.forEach(e-> System.out.println(e.getName()+"------------------->"+e.getAge()));
	}
	@Test
	public void testFindByAgeBetween(){
		List<Employee_TTN> list = repository.findByAgeBetween(28,32);
		list.forEach(e-> System.out.println(e.getName()+"------------------->"
				+e.getLocation()+"------------------->"+e.getAge()));
	}
	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "age");
		Page<Employee_TTN> results = repository.findAll(pageable);
		results.forEach(e-> System.out.println(e.getName()+"------------------->"+e.getAge()));
	}

}
