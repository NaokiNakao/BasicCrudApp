package com.example.basiccrudapp.repository;

import com.example.basiccrudapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
