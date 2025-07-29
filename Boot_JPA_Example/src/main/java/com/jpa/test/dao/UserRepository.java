package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    // Finder methods
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);

    // Custom JPQL queries
    @Query("SELECT u FROM User u")
    public List<User> getAll();

    @Query("SELECT u FROM User u WHERE u.name = :n")
    public List<User> getUserByName(@Param("n") String name);

    // Native SQL query
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    public List<User> getAllUsers();
}
