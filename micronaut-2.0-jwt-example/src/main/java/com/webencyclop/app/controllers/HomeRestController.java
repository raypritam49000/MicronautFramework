package com.webencyclop.app.controllers;

import com.webencyclop.app.entities.User;
import com.webencyclop.app.repositories.UserRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import javax.inject.Inject;

@Controller("/")
@Secured(SecurityRule.IS_ANONYMOUS)
public class HomeRestController {

    @Inject
    private UserRepository userRepository;

    @Get
    public String home() {
        System.out.println("@@@@ ServerStartupEvent ....."+ userRepository.save(new User("admin", "admin")));
        return "Server is  up and running! Use these rest end points: \n[POST]: /login  \n[GET]: /demo/one";
    }


}
