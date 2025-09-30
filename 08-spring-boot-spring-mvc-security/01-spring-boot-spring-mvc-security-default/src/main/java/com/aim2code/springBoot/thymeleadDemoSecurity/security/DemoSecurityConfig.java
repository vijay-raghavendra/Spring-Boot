package com.aim2code.springBoot.thymeleadDemoSecurity.security;

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
public class DemoSecurityConfig {

    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails user1 = User.withUsername("john")
                            .password("{noop}test123")
                            .roles("EMPLOYEE").build();

        UserDetails user2 = User.withUsername("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER").build();

        UserDetails user3 = User.withUsername("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2,user3);

    }*/

    //the below method is used to get the users from the database.
    /*@Bean
    public UserDetailsManager inMemoryUserDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }*/

    // the below method is used to add the suport of user login using the custom tables
    @Bean
    public UserDetailsManager inMemoryUserDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define the query to reterive a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        //define the query to reterive the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");


        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers( "/leaders/**").hasRole("MANAGER")
                        .requestMatchers( "/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form.loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheuser")
                        .permitAll()
        )
                .logout(logout -> logout.permitAll()
        )
                .exceptionHandling(configurer ->
                          configurer.accessDeniedPage("/accessDeniedPage")
                );
        ;
        return http.build();
    }
}
