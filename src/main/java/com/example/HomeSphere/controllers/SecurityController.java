package com.example.HomeSphere.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SecurityController {

    @GetMapping("/auth/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/home")
    public String home() {
        return "/homePage/homePage";
    }

}
