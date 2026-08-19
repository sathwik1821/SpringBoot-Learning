package com.codingshuttle.sathwik.SecurityApplication.services;


import com.codingshuttle.sathwik.SecurityApplication.entities.Session;
import com.codingshuttle.sathwik.SecurityApplication.entities.User;
import com.codingshuttle.sathwik.SecurityApplication.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {


    private final SessionRepository sessionRepository;
    private  final int SESSION_LIMIT=2;

    public void generateNewSession(User user,String refreshToken){

        List<Session> userSessionList=sessionRepository.findByUser(user);

        if(userSessionList.size()==SESSION_LIMIT){
            userSessionList.sort(Comparator.comparing(Session::getLastUsedAt));
            Session leastRecentlyUsedSession=userSessionList.getFirst();
            sessionRepository.delete(leastRecentlyUsedSession);
        }

        Session newSession= Session.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();
        System.out.println("Session is created");
        sessionRepository.save(newSession);
    }

    public void validateSession(String refreshToken){
        Session session= sessionRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new SessionAuthenticationException("Session with refresh token not found"));

        session.setLastUsedAt(LocalDateTime.now());
        sessionRepository.save(session);
    }
}
