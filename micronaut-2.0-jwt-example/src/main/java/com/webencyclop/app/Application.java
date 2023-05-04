package com.webencyclop.app;

import com.webencyclop.app.repositories.UserRepository;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import javax.inject.Inject;

@OpenAPIDefinition(
        info = @Info(
                title = "demo",
                version = "0.0"
        )
)
public class Application {

    @Inject
    private UserRepository userRepository;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

}
