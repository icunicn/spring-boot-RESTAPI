package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DatabaseTestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-db")
    public ResponseEntity<Map<String, Object>> testDatabaseConnection() {
        Map<String, Object> response = new HashMap<>();
        
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                response.put("status", "SUCCESS");
                response.put("message", "Database connection is working!");
                response.put("database", connection.getMetaData().getDatabaseProductName());
                response.put("url", connection.getMetaData().getURL());
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "FAILED");
                response.put("message", "Database connection is closed or null");
                return ResponseEntity.status(500).body(response);
            }
        } catch (Exception e) {
            response.put("status", "ERROR");
            response.put("message", "Database connection failed: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
