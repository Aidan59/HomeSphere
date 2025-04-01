package com.example.HomeSphere.services;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.models.User;
import com.example.HomeSphere.models.UserEvent;
import com.example.HomeSphere.repositories.UserRepository;
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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<UserEvent> getUserEvents(){
        //TODO

        return null;
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            return userRepository.findByLogin(auth.getName()).get();
        }

        throw new RuntimeException();
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
