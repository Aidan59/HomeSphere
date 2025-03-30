package com.example.HomeSphere.controllers;

import com.example.HomeSphere.models.Device;
import com.example.HomeSphere.models.User;
import com.example.HomeSphere.services.EmailService;
import com.example.HomeSphere.services.RegistrationService;
import com.example.HomeSphere.services.UserService;
import com.example.HomeSphere.util.UserValidator;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final RegistrationService registrationService;
    private final EmailService emailService;

    @Autowired
    public SecurityController(UserService userService, UserValidator userValidator, RegistrationService registrationService, EmailService emailService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.registrationService = registrationService;
        this.emailService = emailService;
    }

    @GetMapping("/auth/login")
    public String login() {
        return "/auth/login";
    }


    @GetMapping("/auth/register")
    public String register(@ModelAttribute("user") User user) {
        return "/auth/register";
    }

    @PostMapping("/auth/register")
    public String performRegister(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/auth/register";
        }

        registrationService.register(user);

        return "redirect:/auth/login";
    }

    /*@GetMapping("/mail")
    public String sendMail() throws MessagingException {
        emailService.sendConfirmationEmail(userService.getUserEmail());

        return "/auth/registerEmailConfirm";
    }*/
}
