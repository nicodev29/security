package com.example.basicjwtoauth2.models;

import lombok.Data;

@Data
public class JWTRequest {
    private String username;
    private String password;
}
