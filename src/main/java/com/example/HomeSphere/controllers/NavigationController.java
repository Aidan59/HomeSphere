package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.*;
import com.example.HomeSphere.services.DeviceService;
import com.example.HomeSphere.services.EventService;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@Controller
public class NavigationController {

    @Autowired
    private UserService userService;
    private DeviceService deviceService;
    private EventService eventService;
    private UserDetailsService userDetailsService;

    public NavigationController(UserService userService, DeviceService deviceService, EventService eventService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.eventService = eventService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/homePage/home")
    public String home(@ModelAttribute("device") Device device, Model model) {

        model.addAttribute("events", eventService.getTopEvents());
        model.addAttribute("deviceList", userDetailsService.getCurrentUser().getDeviceList());

        return "/homePage/home";
    }

    @GetMapping("/homePage/devices")
    public String devices(@ModelAttribute("device") Device device, Model model) {

        model.addAttribute("deviceList", userDetailsService.getCurrentUser().getDeviceList());

        return "/homePage/devices";
    }

    @GetMapping("/homePage/events")
    public String events(Model model) {

        model.addAttribute("events", eventService.getTopEvents());

        return "/homePage/events";
    }

    @GetMapping("/homePage/settings")
    public String settings(@ModelAttribute("settings") UserSettings settings, Model model) {

        model.addAttribute("settings", userService.getUserSettings());

        return "/homePage/settings";
    }

    @GetMapping("/homePage/help")
    public String help() {

        return "/homePage/help";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        model.addAttribute("user", userDetailsService.getCurrentUser());

        return "/homePage/profile";
    }



}
