package com.expenses.app.expenses_app.modules.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> 
            auth.requestMatchers(HttpMethod.GET, "/users").permitAll()
            // temporal mientras no se implementa la auth
            .requestMatchers(HttpMethod.GET, "/users/{id}").permitAll()
            .anyRequest().authenticated()
        )    
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // temporal mientras no autentica jwt
        .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
