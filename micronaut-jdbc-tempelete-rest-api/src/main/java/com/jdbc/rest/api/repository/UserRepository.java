package com.jdbc.rest.api.repository;

import com.jdbc.rest.api.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    public Integer createUser(User user) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
    public User getUser(String id) throws SQLException;
    public Boolean deleteUser(String id) throws SQLException;
    public Integer updateUser(String id,User user) throws SQLException;
}
