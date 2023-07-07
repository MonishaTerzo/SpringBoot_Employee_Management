package com.example.asses.demo.Security;

import com.example.asses.demo.EmployeeService.UserService;
import com.example.asses.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration

    public class SecurityConfig {
    UserService userService;
    @Autowired
    public SecurityConfig(UserService user) {
        this.userService = user;
    }



    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        List<UserEntity> users = userService.findAllEmployees();
        InMemoryUserDetailsManager auth = new InMemoryUserDetailsManager();
        System.out.println(users);
        for (UserEntity user : users) {
            UserDetails u= User.builder()
                    .username(user.getUsername())
                    .password("{noop}" + user.getPassword())
                    .build();
            auth.createUser(u);
        }
        return auth;
    }}
