package com.example.games.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.games.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter)
    {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // Beans are just classes created on app startup and stored in context so they can be used throughout the app. Same as @Component or @Service although those tell the app more things
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable()) //why am I disbaling csrf? because its a restful api?
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated()) //this permits all routes with /auth/**, everything else will be JWT authenticated
            .addFilterBefore( //does this filter (middleware) before the default username/password filter
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );
        /**
         * Change the authorizeHttpRequests() method to the following to add more public routes:
         * .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/products/**").authenticated()
                .requestMatchers("/admin/**").authenticated()
                .anyRequest().permitAll()
         */

        return http.build();
    }
    
}
