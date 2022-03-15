package com.example.demo;

import com.example.demo.onetomany.entities.Address;
import com.example.demo.onetomany.entities.Author;
import com.example.demo.onetomany.entities.Book;
import com.example.demo.onetomany.repos.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SpringJpaAssign3ApplicationTests {

	@Autowired
	AuthorRepository repository;

	@Test
	void testCreateAuthorOneToMany() {
		Author author = new Author();
		author.setName("Ruskin Bond");
		author.setAge(57);

		Address address = new Address();
		address.setStreetNumber("1001");
		address.setLocation("Mussoorie");
		address.setState("UK");
		author.setAddress(address);

		Set<Book> books = new HashSet<>();
		Book book = new Book();
		book.setBookName("The girl on the train");
		book.setAuthor(author);

		books.add(book);

		Book book1 = new Book();
		book1.setBookName("Coming home to Dehra");
		book1.setAuthor(author);

		books.add(book1);
		author.setBooks(books);

		repository.save(author);
	}


}
