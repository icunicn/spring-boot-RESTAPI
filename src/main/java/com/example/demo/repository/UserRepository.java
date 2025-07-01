package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JPA Repository interface for User entity
 * Spring Data JPA will automatically implement this interface
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Find user by email
     * @param email User email
     * @return Optional containing user if found
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Check if user exists by email
     * @param email User email
     * @return true if user exists, false otherwise
     */
    boolean existsByEmail(String email);
    
    /**
     * Find users by name containing the given string (case-insensitive)
     * @param name Name to search for
     * @return List of users whose names contain the given string
     */
    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<User> findByNameContaining(@Param("name") String name);
    
    /**
     * Find users by phone number
     * @param phone Phone number
     * @return Optional containing user if found
     */
    Optional<User> findByPhone(String phone);
    
    /**
     * Custom query to find all users ordered by name
     * @return List of users ordered by name
     */
    @Query("SELECT u FROM User u ORDER BY u.name ASC")
    List<User> findAllOrderedByName();
}
