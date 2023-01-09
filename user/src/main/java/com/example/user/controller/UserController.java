package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.RequestUser;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/healthcheck")
    public String status() {
        return "User Service activate";
    }

    @PostMapping("/users")
    public String createUser(@RequestBody RequestUser user) {
        return "create user";
    }
}
