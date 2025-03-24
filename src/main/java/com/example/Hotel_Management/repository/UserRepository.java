package com.example.Hotel_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotel_Management.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
