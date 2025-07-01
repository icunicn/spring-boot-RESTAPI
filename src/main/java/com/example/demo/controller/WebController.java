package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

/**
 * Web Controller for handling HTML page requests
 * This controller returns views (HTML pages) instead of JSON responses
 */
@Controller
public class WebController {
    
    private final UserService userService;
    
    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }
    
    /**
     * Home page
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Home");
        return "index";
    }
    
    /**
     * Users list page
     */
    @GetMapping("/users")
    public String usersList(Model model) {
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("pageTitle", "Users List");
        model.addAttribute("breadcrumb", "Users");
        return "user/list";
    }
    
    /**
     * Show add user form
     */
    @GetMapping("/users/new")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("pageTitle", "Add New User");
        model.addAttribute("breadcrumb", "Add User");
        return "user/form";
    }
    
    /**
     * Show user detail page
     */
    @GetMapping("/users/{id}")
    public String showUserDetail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<UserDTO> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("pageTitle", "User Details");
            model.addAttribute("breadcrumb", "User #" + id);
            return "user/detail";
        } else {
            redirectAttributes.addFlashAttribute("error", "User not found with ID: " + id);
            return "redirect:/users";
        }
    }
    
    /**
     * Show edit user form
     */
    @GetMapping("/users/{id}/edit")
    public String showEditUserForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<UserDTO> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("pageTitle", "Edit User");
            model.addAttribute("breadcrumb", "Edit User #" + id);
            return "user/form";
        } else {
            redirectAttributes.addFlashAttribute("error", "User not found with ID: " + id);
            return "redirect:/users";
        }
    }
    
    /**
     * Handle create user form submission
     */
    @PostMapping("/users")
    public String createUser(@ModelAttribute UserDTO userDTO, RedirectAttributes redirectAttributes) {
        try {
            UserDTO createdUser = userService.createUser(userDTO);
            redirectAttributes.addFlashAttribute("message", 
                "User '" + createdUser.getName() + "' has been created successfully!");
            return "redirect:/users/" + createdUser.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error creating user: " + e.getMessage());
            return "redirect:/users/new";
        }
    }
    
    /**
     * Handle update user form submission
     */
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserDTO userDTO, 
                           RedirectAttributes redirectAttributes) {
        try {
            Optional<UserDTO> updatedUser = userService.updateUser(id, userDTO);
            if (updatedUser.isPresent()) {
                redirectAttributes.addFlashAttribute("message", 
                    "User '" + updatedUser.get().getName() + "' has been updated successfully!");
                return "redirect:/users/" + id;
            } else {
                redirectAttributes.addFlashAttribute("error", "User not found with ID: " + id);
                return "redirect:/users";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating user: " + e.getMessage());
            return "redirect:/users/" + id + "/edit";
        }
    }
    
    /**
     * Handle delete user (via form submission)
     */
    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            boolean deleted = userService.deleteUser(id);
            if (deleted) {
                redirectAttributes.addFlashAttribute("message", "User has been deleted successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "User not found with ID: " + id);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error deleting user: " + e.getMessage());
        }
        return "redirect:/users";
    }
}
