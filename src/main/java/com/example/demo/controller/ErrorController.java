package com.example.demo.controller;

// import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Custom Error Controller to handle error pages
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object exception = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            model.addAttribute("status", statusCode);
            
            // Set appropriate error messages based on status code
            switch (statusCode) {
                case 404:
                    model.addAttribute("error", "Page Not Found");
                    model.addAttribute("message", "The requested page could not be found.");
                    break;
                case 500:
                    model.addAttribute("error", "Internal Server Error");
                    model.addAttribute("message", "An unexpected error occurred on the server.");
                    break;
                default:
                    model.addAttribute("error", "Error " + statusCode);
                    break;
            }
        }
        
        if (exception != null) {
            model.addAttribute("exception", exception.toString());
        }
        
        if (message != null && model.getAttribute("message") == null) {
            model.addAttribute("message", message.toString());
        }
        
        model.addAttribute("pageTitle", "Error");
        return "error";
    }
}
