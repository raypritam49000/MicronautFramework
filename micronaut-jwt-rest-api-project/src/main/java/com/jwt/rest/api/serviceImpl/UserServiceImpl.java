package com.jwt.rest.api.serviceImpl;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.entity.User;
import com.jwt.rest.api.mapper.Assembler;
import com.jwt.rest.api.repository.UserRepository;
import com.jwt.rest.api.security.PasswordEncoder;
import com.jwt.rest.api.service.UserService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private Assembler assembler;

    @Inject
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Inject
    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
       Optional<User> userOptional =  userRepository.findByUsername(username);
        Optional<UserDto> userDtoOptional = Optional.empty();
       if(userOptional.isPresent()){
           userDtoOptional = Optional.of(assembler.mapObject(userOptional.get(), UserDto.class));
       }
       return userDtoOptional;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(PasswordEncoder.encode(userDto.getPassword()));
        return assembler.mapObject(userRepository.save(assembler.mapObject(userDto, User.class)),UserDto.class);
    }
}
