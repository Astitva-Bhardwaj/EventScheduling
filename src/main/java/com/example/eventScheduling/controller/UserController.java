package com.example.eventScheduling.controller;

import com.example.eventScheduling.model.User;
import com.example.eventScheduling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, Model model) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            model.addAttribute("user", user);
            // Redirect based on user role
            return user.isAdmin() ? "redirect:/admin_dashboard?email=" + email : "redirect:/users_dashboard?email=" + email;
        } else {
            model.addAttribute("error", "User not found");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String userDashboard(@RequestParam String email, Model model) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "user_dashboard";
    }

    @GetMapping("/admin_dashboard")
    public String adminDashboard(@RequestParam String email, Model model) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "admin_dashboard";
    }


}