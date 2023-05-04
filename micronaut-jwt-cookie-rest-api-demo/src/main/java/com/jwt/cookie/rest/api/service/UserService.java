package com.jwt.cookie.rest.api.service;



import com.jwt.cookie.rest.api.dto.UserDto;

import java.util.Optional;

public interface UserService {
    public Optional<UserDto> findByUsername(String username);
    public UserDto createUser(UserDto userDto);
}
