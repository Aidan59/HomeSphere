package com.example.HomeSphere.config;

import com.example.HomeSphere.security.AuthProviderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import java.security.AuthProvider;


@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfiguration {

    private final AuthProviderImpl authProvider;

    public SecurityConfig(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}
