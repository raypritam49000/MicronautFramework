package com.rest.jwt.api.mappers;

import com.rest.jwt.api.dtos.UserDto;
import com.rest.jwt.api.entities.User;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;


@Singleton
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCity(userDto.getCity());
        user.setPincode(userDto.getPincode());
        user.setCountry(userDto.getCountry());
        user.setState(userDto.getState());
        return user;
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setCity(user.getCity());
        userDto.setState(user.getState());
        userDto.setPincode(user.getPincode());
        userDto.setCountry(user.getCountry());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public List<UserDto> toDtoList(List<User> users){
        return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }

    public List<User> toEntityList(List<UserDto> userDtos){
        return userDtos.stream().map(userDto -> toEntity(userDto)).collect(Collectors.toList());
    }
}
