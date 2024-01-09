package com.example.basicjwtoauth2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    @GetMapping
    public Map<String,String> account (){
        return Collections.singletonMap("message", "account");
    }

}
