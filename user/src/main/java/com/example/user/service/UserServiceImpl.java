package com.example.user.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.dto.UserDto;
import com.example.user.jpa.UserEntity;
import com.example.user.jpa.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    BCryptPasswordEncoder passEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        // client 단에서 받은 userdto를 entity 클래스로 변환
        UserEntity entity = mapper.map(userDto, UserEntity.class);
        entity.setEncryptedPwd(passEncoder.encode(userDto.getPwd()));
        userRepository.save(entity);

        UserDto userVo = mapper.map(entity, UserDto.class);
        return userVo;
    }

}
