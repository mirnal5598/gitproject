package com.example.demo.onetomany.repos;

import com.example.demo.onetomany.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
