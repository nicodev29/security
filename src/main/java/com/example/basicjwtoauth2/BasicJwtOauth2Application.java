package com.example.basicjwtoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class BasicJwtOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BasicJwtOauth2Application.class, args);
    }

}
