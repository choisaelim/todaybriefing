package com.example.user.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.dto.UserDto;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
