package com.rest.jwt.api.services;

import com.rest.jwt.api.dtos.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserDto> findAllUsers();

    public UserDto findById(Long id);
    public UserDto updateUser(Long id,UserDto userDto);
    public Boolean deleteUser(Long id);
}