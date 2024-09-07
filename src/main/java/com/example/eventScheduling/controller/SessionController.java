package com.example.eventScheduling.controller;

import com.example.eventScheduling.model.Availability;
import com.example.eventScheduling.model.Session;
import com.example.eventScheduling.model.User;
import com.example.eventScheduling.service.AvailabilityService;
import com.example.eventScheduling.service.SessionService;
import com.example.eventScheduling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @Autowired
    AvailabilityService availabilityService;

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String createSessionPage(@RequestParam String adminEmail, Model model) {
        User admin = userService.getUserByEmail(adminEmail);
        model.addAttribute("admin", admin);
        return "create_session";
    }

    @PostMapping("/create")
    public String createSession(@ModelAttribute Session session, @RequestParam String adminEmail) {
        sessionService.createSession(session);
        return "redirect:/admin/dashboard?email=" + adminEmail;
    }

    @GetMapping("/view/{userEmail}")
    public String viewUserSessions(@PathVariable String userEmail, Model model) {
        User user = userService.getUserByEmail(userEmail);
        List<Session> sessions = sessionService.getUserSessions(user);
        List<Availability> availabilities = availabilityService.getUserAvailability(user);
        model.addAttribute("user", user);
        model.addAttribute("sessions", sessions);
        model.addAttribute("availabilities", availabilities);
        return "view_availability";
    }
}