package com.jwt.rest.api.controllers;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.token.jwt.generator.AccessRefreshTokenGenerator;
import io.micronaut.security.token.jwt.render.AccessRefreshToken;
import jakarta.inject.Inject;

import java.util.Map;
import java.util.Optional;

@Controller("/api/v1/auth")
@Secured(SecurityRule.IS_ANONYMOUS)
public class AuthController {

    private UserService userService;
    private AccessRefreshTokenGenerator accessRefreshTokenGenerator;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Inject
    public void setAccessRefreshTokenGenerator(AccessRefreshTokenGenerator accessRefreshTokenGenerator) {
        this.accessRefreshTokenGenerator = accessRefreshTokenGenerator;
    }

    @Post("/login")
    public HttpResponse<?> login(@Body UserDto userDto){
        Authentication authentication = Authentication.build(userDto.getUsername());
        Optional<AccessRefreshToken> accessRefreshToken = accessRefreshTokenGenerator.generate(authentication);
        return HttpResponse.status(HttpStatus.OK).status(200).body(accessRefreshToken.get());
    }

    @Post("/register")
    public HttpResponse<?> register(@Body UserDto userDto){
       Optional<UserDto> userDtoOptional = userService.findByUsername(userDto.getUsername());
       if(userDtoOptional.isPresent()){
           return HttpResponse.status(HttpStatus.CONFLICT).status(409).body(Map.of("status","Conflict","statusCode",409,"message","Username Already Exits!!!"));
       }
       else{
          UserDto registerUser =  userService.createUser(userDto);
           return HttpResponse.status(HttpStatus.CREATED).status(201).body(Map.of("status","Created","statusCode",201,"message","User has been registered","data",registerUser));
       }
    }
}
