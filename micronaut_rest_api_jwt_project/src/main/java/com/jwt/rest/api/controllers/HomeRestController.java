package com.jwt.rest.api.controllers;

import com.jwt.rest.api.repository.UserRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Controller("/")
@Secured(SecurityRule.IS_ANONYMOUS)
public class HomeRestController {

    @Inject
    private UserRepository userRepository;

    @Get
    public String home() {
        return "Server is  up and running! Use these rest end points: \n[POST]: /login  \n[GET]: /demo/one";
    }


}
