package com.jwt.cookie.rest.api.controllers;

import com.jwt.cookie.rest.api.repository.UserRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Controller
@Secured(SecurityRule.IS_AUTHENTICATED)
public class HomeRestController {

    @Inject
    private UserRepository userRepository;

    @Get("/hello")
    public String home() {
        return "Home Rest Api";
    }


}
