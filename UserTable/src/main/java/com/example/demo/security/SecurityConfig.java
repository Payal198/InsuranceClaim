/*package com.example.demo.security;

import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	//Admin user Vs End User
	//Admin--Create bankAccount,viewAll bankAccount,delete a bank account
	//User Creation-- view bankaccount of his/her own 
	
    // User Creation
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder) {
        // InMemoryUserDetailsManager setup with two users
        UserDetails admin = User.withUsername("Shweta")
                .password(encoder.encode("123"))
                .roles("ADMIN", "USER")
                .build();
        UserDetails user = User.withUsername("Janhvi")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);//this is an implementation of userDetailService Interface
    }
    
    
    // Configuring HttpSecurity
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/welcome").permitAll() // Permit all access to /auth/welcome
                .requestMatchers("/auth/user/**").authenticated() // Require authentication for /auth/user/**
                .requestMatchers("/auth/admin/**").authenticated() // Require authentication for /auth/admin/**
            )
            .formLogin(Customizer.withDefaults()); // Enable form-based login
        
        return http.build();
    }
    // Password Encoding
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

*/

