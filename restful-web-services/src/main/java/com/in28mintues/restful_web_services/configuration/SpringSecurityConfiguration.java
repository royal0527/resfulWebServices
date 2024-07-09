package com.in28mintues.restful_web_services.configuration;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //all request should be authenticated
        http.authorizeHttpRequests(auth-> auth.anyRequest().authenticated());

        //if request is not authenticated ,default page should shown
        http.httpBasic(Customizer.withDefaults());
        http.csrf().disable();

        return http.build();
    }
}
