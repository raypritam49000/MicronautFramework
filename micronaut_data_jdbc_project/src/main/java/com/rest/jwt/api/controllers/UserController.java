package com.rest.jwt.api.controllers;

import com.rest.jwt.api.dtos.UserDto;
import com.rest.jwt.api.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.NoSuchElementException;

@Controller("/api/v1/persons")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Get("/message")
    public String hello(){
        return "hello g";
    }

    @Get("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
        throw new RuntimeException("Something went wrong!");
    }

    @Post
    public HttpResponse<?> createUser(@Body UserDto userDto){
        return HttpResponse.status(HttpStatus.CREATED).status(201).body(userService.createUser(userDto));
    }

    @Get
    public HttpResponse<?> getUsers(){
        return HttpResponse.status(HttpStatus.OK).status(200).body(userService.findAllUsers());
    }

    @Get("/{id}")
    public HttpResponse<?> getUser(@PathVariable("id") Long id){
        return HttpResponse.status(HttpStatus.OK).status(200).body(userService.findById(id));
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteUsers(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return HttpResponse.status(HttpStatus.OK).status(200).body(Map.of("status","SUCCESS","statusCode",200,"message","user has been deleted"));
    }

    @Put("/{id}")
    public HttpResponse<?> updateUser(@PathVariable("id") Long id,@Body UserDto userDto){
        return HttpResponse.status(HttpStatus.OK).status(200).body(userService.updateUser(id,userDto));
    }

}
