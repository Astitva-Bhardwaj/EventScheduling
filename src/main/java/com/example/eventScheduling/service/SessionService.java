package com.example.eventScheduling.service;

import com.example.eventScheduling.model.Session;
import com.example.eventScheduling.model.User;
import com.example.eventScheduling.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> getUserSessions(User user) {
        return sessionRepository.findByAttendeesContaining(user);
    }
}
