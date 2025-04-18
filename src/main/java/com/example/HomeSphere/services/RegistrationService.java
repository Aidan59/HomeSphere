package com.example.HomeSphere.services;

import com.example.HomeSphere.models.User;
import com.example.HomeSphere.models.UserSettings;
import com.example.HomeSphere.repositories.UserSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;
    private UserSettingsRepository settingsRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, UserSettingsRepository settingsRepository, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.settingsRepository = settingsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);

        UserSettings userSettings = new UserSettings();
        userSettings.setUser(user);
        userSettings.setEmail_notifications(false);
        userSettings.setTelegram_notifications(false);
        settingsRepository.save(userSettings);
    }
}
