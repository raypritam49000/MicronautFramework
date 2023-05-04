package com.jdbc.rest.api.repository.impl;


import com.jdbc.rest.api.models.User;
import com.jdbc.rest.api.repository.UserRepository;
import jakarta.inject.Singleton;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class UserRepositoryImpl implements UserRepository {

    private final DataSource dataSource;

    public UserRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Integer createUser(User user) throws SQLException {
        PreparedStatement ps = dataSource.getConnection().prepareStatement("insert into user(id,name,email,city,state,country) values(?,?,?,?,?,?)");
        ps.setString(1, UUID.randomUUID().toString());
        ps.setString(2, user.getName());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getCity());
        ps.setString(5, user.getState());
        ps.setString(6,user.getCountry());

        // Execute the statement
       return ps.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
       PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from user");
       ResultSet result = ps.executeQuery();
       List<User> users = new ArrayList<>();
       while (result.next()){
           String id = result.getString("id");
           String name = result.getString("name");
           String email = result.getString("email");
           String city = result.getString("city");
           String state = result.getString("state");
           String country = result.getString("country");
           users.add(new User(id,name,email,city,state,country));
       }
        return users;
    }

    @Override
    public User getUser(String id) throws SQLException {
        PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from user where id = ? ");
        ps.setString(1,id);
        ResultSet result = ps.executeQuery();
        User user = null;
        if(result.next()){
            String uId = result.getString("id");
            String name = result.getString("name");
            String email = result.getString("email");
            String city = result.getString("city");
            String state = result.getString("state");
            String country = result.getString("country");
            user = new User(uId,name,email,city,state,country);
        }
        return user;
    }

    @Override
    public Boolean deleteUser(String id) throws SQLException {
        PreparedStatement ps = dataSource.getConnection().prepareStatement("delete form user where id = ?");
        ps.setString(1,id);
        Integer isDeleted = ps.executeUpdate();
        return (isDeleted>0) ? true : false;
    }

    @Override
    public Integer updateUser(String id,User user) throws SQLException {
        PreparedStatement ps = dataSource.getConnection().prepareStatement("update user set name = ?,email=?,city=?,state=?,country=? where id = ?");
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCity());
        ps.setString(4, user.getState());
        ps.setString(5,user.getCountry());
        ps.setString(6, id);

        // Execute the statement
        return ps.executeUpdate();
    }
}
