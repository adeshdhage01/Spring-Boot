package com.smart.config;

// Importing necessary classes from Spring Security and Spring Framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  // This tells Spring that this class contains configuration settings
public class MyConfig {

    // This method returns an object that helps Spring Security get user information (like username and password) from the database
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(); // This is your custom class that implements how user data is loaded
    }

    // This method returns an object that encodes passwords using the BCrypt algorithm (for security)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // This method sets up the authentication provider, which tells Spring how to check user login details
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService()); // Use our custom user details service
        authProvider.setPasswordEncoder(passwordEncoder());       // Use BCrypt to compare passwords
        return authProvider;
    }

    // This method returns the AuthenticationManager, which is used to handle login authentication
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Get the default authentication manager from Spring
    }

    // This method sets up security rules for different URLs (who can access what)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/user/index")
                .and()
                .csrf().disable();
        
        return http.build();
    }
}
