package com.example.HomeSphere.services;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.models.User;
import com.example.HomeSphere.models.UserSettings;
import com.example.HomeSphere.repositories.EventRepository;
import com.example.HomeSphere.repositories.UserRepository;
import com.example.HomeSphere.repositories.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserDetailsService userDetailsService;
    private EventRepository eventRepository;
    private UserSettingsRepository userSettingsRepository;

    public UserService(UserRepository userRepository, UserDetailsService userDetailsService, EventRepository eventRepository, UserSettingsRepository userSettingsRepository) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.eventRepository = eventRepository;
        this.userSettingsRepository = userSettingsRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void logUserEvent(Event userEvent) {
        eventRepository.save(userEvent);
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
