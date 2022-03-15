package com.example.demo;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
