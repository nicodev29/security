package com.example.basicjwtoauth2.controllers;

import com.example.basicjwtoauth2.models.JWTRequest;
import com.example.basicjwtoauth2.models.JWTResponse;
import com.example.basicjwtoauth2.service.JWTUserDetailService;
import com.example.basicjwtoauth2.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTUserDetailService jwtUserDetailService;
    private final JwtService jwtService;


    @PostMapping("/token")
    public ResponseEntity<?> postToken(@RequestBody JWTRequest request) {
        this.authenticate(request);

        final var userDetails = this.jwtUserDetailService.loadUserByUsername(request.getUsername());

        final var token = this.jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token));
    }

    @GetMapping("/authenticate")
    private void authenticate(JWTRequest request) {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException | DisabledException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
