package com.jdbc.rest.api.controllers;

import com.jdbc.rest.api.models.User;
import com.jdbc.rest.api.service.UserService;
import io.micronaut.http.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@Controller("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/hello")
    public String hello() throws SQLException {
        return "hello";
    }

    @Get
    public Map<String,Object>  getUsers() throws SQLException {
        return Map.of("status","Success","statusCode",200,"message","User List","data",userService.getAllUsers());
    }

    @Post
    public Map<String,Object> createUser(@Body User user) throws SQLException {
         userService.createUser(user);
         return Map.of("status","Created","statusCode",201,"message","User has been Created");
    }

    @Put("/{id}")
    public Map<String,Object> updateUser(@PathVariable("id") String id, @Body User user) throws SQLException {
        userService.updateUser(id,user);
        return Map.of("status","Updated","statusCode",200,"message","User has been updated");
    }

    @Get("/{id}")
    public Map<String,Object> getUser(@PathVariable("id") String id) throws SQLException {
        return Map.of("status","Success","statusCode",200,"message","User Details","data",userService.getUser(id));
    }


    @Delete("/{id}")
    public Map<String,Object> deleteUser(@PathVariable("id") String id) throws SQLException {
        if(userService.deleteUser(id)){
            return Map.of("status","Success","statusCode",200,"message","User has been deleted");
        }
        else{
            return Map.of("status","Internal Server Error","statusCode",500,"message","User has been not deleted");
        }
    }


}
