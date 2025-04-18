package com.example.HomeSphere.handlers;

import com.example.HomeSphere.models.Event;
import com.example.HomeSphere.services.UserDetailsService;
import com.example.HomeSphere.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LogoutSuccessHandler implements LogoutHandler {

    @Autowired
    private UserDetailsService userDetailsService;
    private UserService userService;

    public LogoutSuccessHandler(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String sec_ch_ua = request.getHeader("Sec-Ch-Ua");
        Event userEvent = new Event();

        userEvent.setUser(userDetailsService.getCurrentUser());
        userEvent.setEvent("Logout from session was performed from " + request.getHeader("Sec-Ch-Ua").substring(sec_ch_ua.lastIndexOf(',') + 1, sec_ch_ua.lastIndexOf(';')).replace('\"', ' ') + ", " + request.getHeader("Sec-Ch-Ua-Platform").replace('\"', ' '));
        userEvent.setTime(LocalDateTime.now());

        userService.logUserEvent(userEvent);

    }
}
