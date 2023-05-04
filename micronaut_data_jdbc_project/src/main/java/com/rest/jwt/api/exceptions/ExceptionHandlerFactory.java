package com.rest.jwt.api.exceptions;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Factory
public class ExceptionHandlerFactory {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerFactory.class);

    @Bean
    @Singleton
    public ExceptionHandler<RuntimeException, HttpStatusException> runtimeExceptionHandler() {
        return (request, exception) -> {
            LOG.error("Caught runtime exception: ", exception);
            return new HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
        };
    }

    @Bean
    @Singleton
    public ExceptionHandler<Exception, Map<String, Object>> genericExceptionHandler() {
        return (request, exception) -> {
            LOG.error("Caught exception: ", exception);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "An error occurred");
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.getCode());
            return response;
        };
    }

    @Bean
    @Singleton
    public ExceptionHandler<ResourceNotFound,Map<String, Object>> noSuchElementExceptionHandler() {
        return (request, exception) -> {
            LOG.error("Caught NoSuchElementException: ", exception);
            return Map.of("status","SUCCESS","statusCode",404,"message", exception.getMessage());
        };
    }

}



