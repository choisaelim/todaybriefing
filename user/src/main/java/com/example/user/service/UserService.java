package com.example.user.service;

import org.springframework.stereotype.Service;

import com.example.user.dto.UserDto;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
}
