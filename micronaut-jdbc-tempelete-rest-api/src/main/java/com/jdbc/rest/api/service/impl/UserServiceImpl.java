package com.jdbc.rest.api.service.impl;

import com.jdbc.rest.api.models.User;
import com.jdbc.rest.api.repository.UserRepository;
import com.jdbc.rest.api.service.UserService;
import jakarta.inject.Singleton;

import java.sql.SQLException;
import java.util.List;

@Singleton
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Integer createUser(User user) throws SQLException {
      return userRepository.createUser(user);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(String id) throws SQLException {
        return userRepository.getUser(id);
    }

    @Override
    public Boolean deleteUser(String id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public Integer updateUser(String id,User user) throws SQLException {
      return userRepository.updateUser(id,user);
    }
}
