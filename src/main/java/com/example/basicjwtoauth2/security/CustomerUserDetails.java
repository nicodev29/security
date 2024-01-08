package com.example.basicjwtoauth2.security;

import com.example.basicjwtoauth2.models.Role;
import com.example.basicjwtoauth2.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Transactional
public class CustomerUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.customerRepository.findByEmail(username)
                .map(customer -> {
                            return new User(
                                    customer.getEmail(),
                                    customer.getPassword(),
                                    customer.getRoles().stream()
                                            .map(Role::getName)
                                            .map(SimpleGrantedAuthority::new)
                                            .collect(Collectors.toList())
                            );

                        }

                ).orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
    }
}
