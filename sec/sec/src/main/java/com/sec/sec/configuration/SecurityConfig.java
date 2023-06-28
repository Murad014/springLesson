package com.sec.sec.configuration;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}user1")
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(user);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure ->
                configure.requestMatchers("/student/addForm").hasAnyRole("STUDENT", "ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form.loginPage("/login")
                        .loginProcessingUrl("/authLogin")
                        .permitAll()
        ).logout(LogoutConfigurer::permitAll).exceptionHandling(denied ->
                denied.accessDeniedPage("/accessDenied")
        );

        return httpSecurity.build();
    }




}
