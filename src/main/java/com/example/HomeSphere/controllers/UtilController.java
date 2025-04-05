package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.UserSettings;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UtilController {

    @Autowired
    private UserDetailsService userDetailsService;
    private UserService userService;

    public UtilController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/settings/update")
    public String updateSettings(@ModelAttribute("settings") UserSettings settings) {

        userService.updateUserSettings(settings);

        return "redirect:/homePage/settings";
    }
}
