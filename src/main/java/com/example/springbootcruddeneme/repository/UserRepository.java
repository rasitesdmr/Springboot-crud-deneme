package com.example.springbootcruddeneme.repository;

import com.example.springbootcruddeneme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByFirstName(String firstName);
}
