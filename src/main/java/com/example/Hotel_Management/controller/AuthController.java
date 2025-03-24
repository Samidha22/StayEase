package com.example.Hotel_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.Hotel_Management.entity.User;
import com.example.Hotel_Management.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/hotel";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, String password, HttpSession session, Model model) {
	    User user = userRepository.findByUsername(username);
	    if (user != null && user.getPassword().equals(password)) {
	        session.setAttribute("loggedInUser", user);
	        session.setAttribute("role", user.getRole());  // Store role in session
	        return "redirect:/hotel";
	    } else {
	        model.addAttribute("error", "Invalid Username or Password");
	    }
	    return "login";
	}
	
	@GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    // NEW: Process registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user,
                               @RequestParam String confirmPassword,
                               Model model) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        
        // Basic password confirmation check
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        
        // Set default role (e.g., USER)
        user.setRole("USER");
        
        // Optionally: encode the password here before saving
        userRepository.save(user);
        
        model.addAttribute("message", "Registration successful! Please login.");
        return "login";
    }

	
}
