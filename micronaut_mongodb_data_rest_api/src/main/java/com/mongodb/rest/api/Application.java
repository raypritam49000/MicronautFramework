package com.mongodb.rest.api;

import io.micronaut.context.annotation.Requires;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import jakarta.inject.Singleton;

@OpenAPIDefinition(
        info = @Info(
                title = "micronaut_mongodb_data_rest_api",
                version = "0.0",
                description = "My API",
                license = @License(name = "Apache 2.0", url = "https://foo.bar"),
                contact = @Contact(url = "https://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
        )
)
@Singleton
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @EventListener
    @Requires(env = "dev")
    public void onServerStartUpInDev(ServerStartupEvent event){
        System.out.println("This code execute in start up time in dev");
    }

    @EventListener
    @Requires(env = "prod")
    public void onServerStartUpInProd(ServerStartupEvent event){
        System.out.println("This code execute in start up time in prod");
    }

    @EventListener
    @Requires(env = "local")
    public void onServerStartUpInDefault(ServerStartupEvent event){
        System.out.println("This code execute in start up time in default");
    }
}