package com.jwt.cookie.rest.api.controllers;

import com.jwt.cookie.rest.api.dto.UserDto;
import com.jwt.cookie.rest.api.service.UserService;
import com.nimbusds.jwt.JWTParser;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.security.Principal;
import java.text.ParseException;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

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
    public UserDto currentUser(@Header(AUTHORIZATION) String token, Principal principal) throws ParseException {
        System.out.println(token.split(" ")[1]);
        System.out.println(JWTParser.parse(token.split(" ")[1]));
       return this.userService.findByUsername(principal.getName()).get();
    }
}
