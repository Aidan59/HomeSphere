package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.User;
import com.example.HomeSphere.services.RegistrationService;
import com.example.HomeSphere.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private final UserValidator userValidator;
    private final RegistrationService registrationService;

    @Autowired
    public SecurityController(UserValidator userValidator, RegistrationService registrationService) {
        this.userValidator = userValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/auth/login")
    public String login() {
        return "/auth/login";
    }

    @GetMapping("/home")
    public String home() {
        return "/homePage/homePage";
    }

    @GetMapping("/auth/register")
    public String register(@ModelAttribute("user") User user) {
        return "/auth/register";
    }

    @PostMapping("/auth/register")
    public String performRegister(@ModelAttribute("user") User user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/auth/register";
        }

        registrationService.register(user);

        return "redirect:/auth/login";

        //TODO
        //Test registration
    }
}
