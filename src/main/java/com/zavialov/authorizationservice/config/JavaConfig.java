package com.zavialov.authorizationservice.config;

import com.zavialov.authorizationservice.controller.AuthorizationController;
import com.zavialov.authorizationservice.repository.UserRepository;
import com.zavialov.authorizationservice.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationController authorizationController() {
        return new AuthorizationController();
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
