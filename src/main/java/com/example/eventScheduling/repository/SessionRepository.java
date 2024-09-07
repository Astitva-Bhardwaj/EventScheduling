package com.example.eventScheduling.repository;

import com.example.eventScheduling.model.Session;
import com.example.eventScheduling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByAttendeesContaining(User user);
}
