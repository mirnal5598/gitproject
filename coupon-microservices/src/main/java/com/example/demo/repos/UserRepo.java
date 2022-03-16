package com.example.demo.repos;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
