package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.Group;
import com.example.HomeSphere.models.UserSettings;
import com.example.HomeSphere.services.DeviceService;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilController {

    @Autowired
    private UserDetailsService userDetailsService;
    private UserService userService;
    private DeviceService deviceService;

    public UtilController(UserDetailsService userDetailsService, UserService userService, DeviceService deviceService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @PostMapping("/settings/update")
    public String updateSettings(@ModelAttribute("settings") UserSettings settings) {

        userService.updateUserSettings(settings);

        return "redirect:/homePage/settings";
    }

    @PostMapping("/addGroup")
    public String addGroup(@ModelAttribute("newGroup") Group newGroup) {

        newGroup.setUser(userDetailsService.getCurrentUser());
        deviceService.save(newGroup);

        return "redirect:/homePage/devices";
    }
}
