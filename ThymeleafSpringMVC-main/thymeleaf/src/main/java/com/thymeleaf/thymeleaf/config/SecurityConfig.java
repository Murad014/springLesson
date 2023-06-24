package com.thymeleaf.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource source){
        return new JdbcUserDetailsManager(source);
    }

    /*@Bean // For prodoction set users manually is not best practice.
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails murad = User.builder()
                .username("murad")
                .password("{noop}olmaz1")
                .roles("STUDENT")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}olmaz12")
                .roles("ADMIN", "STUDENT")
                .build();

        return new InMemoryUserDetailsManager(murad, admin);
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configure ->
                configure.requestMatchers("/student/addForm").hasAnyRole("STUDENT", "ADMIN")
                        .requestMatchers("/student/add").hasAnyRole("STUDENT", "ADMIN")
                        .requestMatchers("/student/updateForm").hasRole("ADMIN")
                        .requestMatchers("/student/update").hasRole("ADMIN")
                        .requestMatchers("/student/delete").hasRole("ADMIN")
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
