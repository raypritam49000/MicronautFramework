package com.jwt.rest.api.controllers;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.services.UserService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.security.Principal;

@Controller("/api/v1/users")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class UserController {

    private UserService userService;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/currentUser")
    public UserDto currentUser(Principal principal) {
       return this.userService.findByUsername(principal.getName()).get();
    }
}
