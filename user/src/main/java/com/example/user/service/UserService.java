package com.example.user.service;

import org.springframework.stereotype.Service;

import com.example.user.dto.UserDto;
import com.example.user.jpa.UserEntity;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();
}
