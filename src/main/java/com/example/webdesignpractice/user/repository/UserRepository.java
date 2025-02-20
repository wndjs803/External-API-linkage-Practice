package com.example.webdesignpractice.user.repository;

import com.example.webdesignpractice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
