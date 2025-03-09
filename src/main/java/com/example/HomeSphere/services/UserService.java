package com.example.HomeSphere.services;

import com.example.HomeSphere.models.User;
import com.example.HomeSphere.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserEmail() {
        // TODO
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
    }
}
