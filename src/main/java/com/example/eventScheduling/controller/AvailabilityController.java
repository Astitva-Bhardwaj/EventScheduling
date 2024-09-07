package com.example.eventScheduling.controller;

import com.example.eventScheduling.model.Availability;
import com.example.eventScheduling.model.User;
import com.example.eventScheduling.service.AvailabilityService;
import com.example.eventScheduling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/availabilities")
public class AvailabilityController {
    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private UserService userService;

    @GetMapping("/set")
    public String setAvailabilityPage(@RequestParam String email, Model model) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "set_availability";
    }

    @PostMapping("/set")
    public String setAvailability(@RequestParam String email, @ModelAttribute Availability availability) {
        User user = userService.getUserByEmail(email);
        availability.setUser(user);
        availabilityService.createAvailability(availability);
        return "redirect:/users/dashboard?email=" + email;
    }

    @GetMapping("/view/{userEmail}")
    public String viewUserAvailability(@PathVariable String userEmail, Model model) {
        User user = userService.getUserByEmail(userEmail);
        List<Availability> availabilities = availabilityService.getUserAvailability(user);
        model.addAttribute("user", user);
        model.addAttribute("availabilities", availabilities);
        return "view_availability";
    }
}