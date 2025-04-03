package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.Device;
import com.example.HomeSphere.services.DeviceService;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DevicesController {

    @Autowired
    private UserService userService;
    private DeviceService deviceService;
    private UserDetailsService userDetailsService;

    public DevicesController(UserService userService, DeviceService deviceService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/addCamera")
    public String addCamera(@ModelAttribute("device") @Valid Device device, BindingResult bindingResult) {

        device.setUser_id(userDetailsService.getCurrentUser());
        deviceService.save(device);

        return "redirect:/homePage/home";
    }
}
