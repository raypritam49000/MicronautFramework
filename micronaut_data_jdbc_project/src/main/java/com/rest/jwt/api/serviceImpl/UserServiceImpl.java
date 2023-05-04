package com.rest.jwt.api.serviceImpl;

import com.rest.jwt.api.dtos.UserDto;
import com.rest.jwt.api.entities.User;
import com.rest.jwt.api.exceptions.ResourceNotFound;
import com.rest.jwt.api.mappers.UserMapper;
import com.rest.jwt.api.repositories.UserRepository;
import com.rest.jwt.api.services.UserService;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class UserServiceImpl implements UserService{

    private final UserRepository usersRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userMapper.toDto(usersRepository.save(userMapper.toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userMapper.toDtoList((List<User>) usersRepository.findAll());
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toDto(usersRepository.findById(id).orElseThrow(()->new ResourceNotFound("User Not Found with id :"+id)));
    }

    @Transactional
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
       Optional<User> userOptional =  usersRepository.findById(id);
       if(userOptional.isPresent()){
           userDto.setId(id);
           return userMapper.toDto(usersRepository.update(userMapper.toEntity(userDto)));
       }
       else{
           throw new ResourceNotFound("User Not Found with id :"+id);
       }
    }

    @Override
    public Boolean deleteUser(Long id) {
        usersRepository.deleteById(id);
        return true;
    }
}
