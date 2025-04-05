package com.example.HomeSphere.services;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.models.User;
import com.example.HomeSphere.models.UserEvent;
import com.example.HomeSphere.models.UserSettings;
import com.example.HomeSphere.repositories.UserEventRepository;
import com.example.HomeSphere.repositories.UserRepository;
import com.example.HomeSphere.repositories.UserSettingsRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserDetailsService userDetailsService;
    private UserEventRepository userEventRepository;
    private UserSettingsRepository userSettingsRepository;

    public UserService(UserRepository userRepository, UserDetailsService userDetailsService, UserEventRepository userEventRepository, UserSettingsRepository userSettingsRepository) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.userEventRepository = userEventRepository;
        this.userSettingsRepository = userSettingsRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void logUserEvent(UserEvent userEvent) {
        userEventRepository.save(userEvent);
    }

    public void updateUserSettings(UserSettings userSettings) {
        UserSettings us = userSettingsRepository.findUserSettingsById(userDetailsService.getCurrentUser().getId());
        us.setEmail_notifications(userSettings.isEmail_notifications());
        us.setTelegram_notifications(userSettings.isTelegram_notifications());

        userSettingsRepository.save(us);
    }

    public UserSettings getUserSettings() {
        return userSettingsRepository.findById(userDetailsService.getCurrentUser().getId()).get();
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
