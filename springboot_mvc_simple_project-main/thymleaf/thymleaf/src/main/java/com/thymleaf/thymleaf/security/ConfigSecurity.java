package com.thymleaf.thymleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    @Bean
    public InMemoryUserDetailsManager inMemoryConfiguration(){
        UserDetails murad = User.builder()
                .username("murad")
                .password("{noop}murad123")
                .roles("STUDENT")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("STUDENT", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(murad, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                    configurer.anyRequest().authenticated()
                ).formLogin(form ->

                    form
                            .loginPage("/showMyLoginPage")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
                ).logout(LogoutConfigurer::permitAll);

        return http.build();

    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests( configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/students/list").hasRole("STUDENT")
//        );
//
//        http.httpBasic();
//
//        return http.build();
//
//    }





}
