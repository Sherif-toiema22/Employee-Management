package com.example.Sherif.repository;

import com.example.Sherif.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User  findByEmail(String email);
}
