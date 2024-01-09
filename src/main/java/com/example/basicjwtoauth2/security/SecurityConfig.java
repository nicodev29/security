package com.example.basicjwtoauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {
    private final CustomerUserDetails customerUserDetails;
    public SecurityConfig(CustomerUserDetails customerUserDetails) {
        this.customerUserDetails = customerUserDetails;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/loans","/account").hasAnyAuthority("ADMIN")
                        .requestMatchers("/balance","/cards").hasAnyAuthority("USER")
                        .requestMatchers("/about_us", "/welcome").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        http.userDetailsService(customerUserDetails);

        return http.build();
    }



    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

            var config = new CorsConfiguration();
            config.setAllowedOrigins(List.of("http://localhost:4200"));
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            config.setAllowedHeaders(List.of("*"));

            var source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);
            return source;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }



//    @Bean
//    InMemoryUserDetailsManager userDetailsManager() {
//
//        var admin = User.withUsername("admin")
//                .password("admin")
//                .authorities("ADMIN")
//                .build();
//
//        var user = User.withUsername("user")
//                .password("user")
//                .authorities("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    UserDetailsService userDetailsService (DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

}
