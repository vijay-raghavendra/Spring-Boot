package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class accessAndRolesConfig {

    @Bean
    public UserDetailsManager  userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");

        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

        return userDetailsManager;
    }

    //Method for authorization using username and password from Database default tables
   /* @Bean
    public UserDetailsManager  userDetailsManager(DataSource dataSource) {

        return new  JdbcUserDetailsManager(dataSource);
    }*/

    //Method for authorization using username and password from codebase
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user1 = User.builder().username("sushanth").password("{noop}sushanth").roles("EMPLOYEE").build();

        UserDetails user2 = User.builder().username("naveen").password("{noop}naveen").roles("EMPLOYEE","MANAGER").build();

        UserDetails user3 = User.builder().username("vijay").password("{noop}vijay").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2, user3);

    }*/

    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                );

        //USING HTTP BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());

        //DISABLING CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
