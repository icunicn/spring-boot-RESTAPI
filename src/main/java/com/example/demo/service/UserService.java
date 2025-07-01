package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for User business logic
 */
public interface UserService {
    
    /**
     * Create a new user
     * @param userDTO User data
     * @return Created user DTO
     */
    UserDTO createUser(UserDTO userDTO);
    
    /**
     * Get user by ID
     * @param id User ID
     * @return Optional containing user DTO if found
     */
    Optional<UserDTO> getUserById(Long id);
    
    /**
     * Get user by email
     * @param email User email
     * @return Optional containing user DTO if found
     */
    Optional<UserDTO> getUserByEmail(String email);
    
    /**
     * Get all users
     * @return List of all user DTOs
     */
    List<UserDTO> getAllUsers();
    
    /**
     * Update user
     * @param id User ID
     * @param userDTO Updated user data
     * @return Updated user DTO
     */
    Optional<UserDTO> updateUser(Long id, UserDTO userDTO);
    
    /**
     * Delete user by ID
     * @param id User ID
     * @return true if user was deleted, false if not found
     */
    boolean deleteUser(Long id);
}
