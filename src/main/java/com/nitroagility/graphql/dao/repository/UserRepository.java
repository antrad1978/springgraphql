package com.nitroagility.graphql.dao.repository;

import com.nitroagility.graphql.dao.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
