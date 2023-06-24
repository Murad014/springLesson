package com.studentMVC.studentMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class SecurityConfig {
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, user_pass, is_active from users where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, user_role, is_active from roles where username=?");

        return jdbcUserDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}user1")
//                .roles("STUDENT")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}admin1")
//                .roles("ADMIN", "STUDENT")
//                .build();
//
//        UserDetails manager = User.builder()
//                .username("manager")
//                .password("{noop}manager1")
//                .roles("STUDENT", "MANAGER")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user, admin, manager);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(config -> config
                .requestMatchers("/student/list").hasAnyRole("STUDENT", "ADMIN")
                .requestMatchers("/student/addForm").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers("/student/add").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers("/student/updateForm").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/student/update").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/student/delete").hasRole("ADMIN")
                .anyRequest().authenticated())

                .formLogin(form ->
                        form.loginPage("/login")
                                .loginProcessingUrl("/auth")
                                .permitAll())
                .logout(LogoutConfigurer::permitAll).exceptionHandling(
                        denied ->
                                denied.accessDeniedPage("/accessDenied")
                );


        return httpSecurity.build();

    }



}
