package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.Device;
import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.services.DeviceService;
import com.example.HomeSphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class NavigationController {

    @Autowired
    private UserService userService;
    private DeviceService deviceService;

    public NavigationController(UserService userService, DeviceService deviceService) {
        this.userService = userService;
        this.deviceService = deviceService;
    }

    @GetMapping("/homePage/home")
    public String home(@ModelAttribute("device") Device device, Model model) {
        List<Event> events = new ArrayList<>();
        /*Collections.addAll();*/

        model.addAttribute("deviceList", userService.getCurrentUser().getDeviceList());

        return "/homePage/home";
    }

    @GetMapping("/homePage/devices")
    public String devices(@ModelAttribute("device") Device device, Model model) {

        model.addAttribute("deviceList", userService.getCurrentUser().getDeviceList());

        return "/homePage/devices";
    }

    @GetMapping("/homePage/events")
    public String events(Model model) {

        return "/homePage/events";
    }

    @GetMapping("/homePage/settings")
    public String settings(Model model) {

        return "/homePage/settings";
    }

    @GetMapping("/homePage/help")
    public String help(Model model) {

        return "/homePage/help";
    }



}
