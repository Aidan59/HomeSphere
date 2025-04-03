package com.example.HomeSphere.services;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.models.User;
import com.example.HomeSphere.models.UserEvent;
import com.example.HomeSphere.repositories.UserEventRepository;
import com.example.HomeSphere.repositories.UserRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserEventRepository userEventRepository;

    public UserService(UserRepository userRepository, UserEventRepository userEventRepository) {
        this.userRepository = userRepository;
        this.userEventRepository = userEventRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void logUserEvent(UserEvent userEvent) {
        userEventRepository.save(userEvent);
    }

    /*public String getUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            Optional<User> user = userRepository.findByLogin(auth.getName());
            if (user.isPresent()) {
                return user.get().getEmail();
            } else {
                throw new RuntimeException("User service error");
            }
        }
        throw new RuntimeException("User service error");
    }*/
}
