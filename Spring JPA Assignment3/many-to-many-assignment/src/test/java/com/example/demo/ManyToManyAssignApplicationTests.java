package com.example.demo;

import com.example.demo.entities.Address;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repos.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class ManyToManyAssignApplicationTests {

	@Autowired
	AuthorRepository repository;
	@Test
	public void testmanyToManyCreateProgrammer(){
		Author author = new Author();
		author.setName("Stephen King");
		author.setAge(60);

		Address address = new Address();
		address.setStreetNumber("1005");
		address.setLocation("Maharashtra");
		address.setState("Mumbai");
		author.setAddress(address);

		HashSet<Book> books = new HashSet<Book>();
		Book book = new Book();
		book.setBookName("Shining");
		books.add(book);
		author.setBooks(books);
		repository.save(author);
	}


}
