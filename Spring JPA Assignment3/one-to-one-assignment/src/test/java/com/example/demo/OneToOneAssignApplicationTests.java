package com.example.demo;

import com.example.demo.entities.Address;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToOneAssignApplicationTests {

	@Autowired
	BookRepository repository;

	@Test
	public void testCreateAuthorOneToOne(){
		Author author = new Author();
		author.setName("Stephen King");
		author.setAge(50);

		Address address = new Address();
		address.setStreetNumber("1004");
		address.setLocation("Jaipur");
		address.setState("Rajasthan");
		author.setAddress(address);

		Book book = new Book();
		book.setBookName("The Shining");
		book.setAuthor(author);

		repository.save(book);
	}

}
