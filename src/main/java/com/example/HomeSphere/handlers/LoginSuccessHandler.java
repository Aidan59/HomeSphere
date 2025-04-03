package com.example.HomeSphere.handlers;

import com.example.HomeSphere.models.UserEvent;
import com.example.HomeSphere.repositories.UserEventRepository;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserDetailsService userDetailsService;
    private UserService userService;

    public LoginSuccessHandler(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String sec_ch_ua = request.getHeader("Sec-Ch-Ua");

        UserEvent userEvent = new UserEvent(userDetailsService.getCurrentUser(), "Login was performed from " +
                request.getHeader("Sec-Ch-Ua").substring(sec_ch_ua.lastIndexOf(',') + 1, sec_ch_ua.lastIndexOf(';')).replace('\"', ' ') +
                ", " +
                request.getHeader("Sec-Ch-Ua-Platform").replace('\"', ' '),
                LocalDateTime.now());
        userService.logUserEvent(userEvent);


        response.sendRedirect("/homePage/home");
    }
}
