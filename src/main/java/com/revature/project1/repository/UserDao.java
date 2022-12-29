package com.revature.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project1.models.User;

public interface UserDao extends JpaRepository<User, Integer> {

    // Returns the User with the given username wrapped in an Optional, or an empty
    // Optional if no such User exists
    Optional<User> findByUsername(String username);

    // Creates a new User with the given username and password
    @Modifying
    @Transactional
    @Query(value = "insert into users value values(:username, :password)", nativeQuery = true)
    void createUser(@Param("username") String username, @Param("password") String password);

}
