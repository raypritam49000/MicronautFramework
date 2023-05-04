package com.auth.rest.controllers;

import com.nimbusds.jwt.JWTParser;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.CookieValue;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller 
public class HomeController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";

    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/api/hello")
    public String hello() {
        return "Hello, world!";
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @View("home")
    @Get
    public Map<String, Object> index() {
        return new HashMap<>();
    }


    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Produces(MediaType.APPLICATION_JSON)
    @Get("/token")
    public HttpResponse<?> getAccessToken(@CookieValue("JWT") String token) throws ParseException {
        LOGGER.info("@@@ userinfo : "+ JWTParser.parse(token).getJWTClaimsSet().getClaim("email"));
        return HttpResponse.status(HttpStatus.OK).status(200).body(Map.of("token",token,"type",BEARER_TOKEN_PREFIX));
    }

}