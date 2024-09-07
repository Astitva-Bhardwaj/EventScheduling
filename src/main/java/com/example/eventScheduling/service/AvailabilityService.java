package com.example.eventScheduling.service;

import com.example.eventScheduling.model.Availability;
import com.example.eventScheduling.model.User;
import com.example.eventScheduling.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public List<Availability> getUserAvailability(User user) {
        return availabilityRepository.findByUser(user);
    }
}
