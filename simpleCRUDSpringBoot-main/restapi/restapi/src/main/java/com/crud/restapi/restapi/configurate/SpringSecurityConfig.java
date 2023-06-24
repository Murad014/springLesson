package com.crud.restapi.restapi.configurate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource source){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(source);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, active from users where username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, user_role, active from roles where username=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers(HttpMethod.GET, "/api/students").hasRole("USER")
                            .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("USER")
                            .requestMatchers(HttpMethod.POST, "/api/students").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/api/students").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")
        );


        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();
        return httpSecurity.build();

    }

//    @Bean
//    public InMemoryUserDetailsManager memoryUserDetailsManager(){
//        UserDetails murad = User.builder()
//                .username("murad")
//                .password("{noop}1234")
//                .roles("USER", "ADMIN")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(murad, user);
//    }
//

}
