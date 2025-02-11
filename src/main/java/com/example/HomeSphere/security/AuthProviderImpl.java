package com.example.HomeSphere.security;

import com.example.HomeSphere.models.User;
import com.example.HomeSphere.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthProviderImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String password = authentication.getCredentials().toString();

        if(!userDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("Bad credentials");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
