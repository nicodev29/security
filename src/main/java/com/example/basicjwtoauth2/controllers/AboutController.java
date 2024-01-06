package com.example.basicjwtoauth2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/about_us")
public class AboutController {

    @GetMapping
    public Map<String,String> about (){
        return Collections.singletonMap("message", "about us");
    }
}
