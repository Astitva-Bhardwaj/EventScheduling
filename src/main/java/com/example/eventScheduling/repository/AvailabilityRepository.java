package com.example.eventScheduling.repository;

import com.example.eventScheduling.model.Availability;
import com.example.eventScheduling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByUser(User user);
}
