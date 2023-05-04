package com.jwt.rest.api.security;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.services.UserService;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    private UserService userService;

    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            Optional<UserDto> user = checkIfUserExists(authenticationRequest);
            if (user.isPresent() && authenticationRequest.getSecret() instanceof String) {
                String password = authenticationRequest.getSecret().toString();
                if(PasswordEncoder.matches(password,user.get().getPassword())){
                    emitter.onNext(AuthenticationResponse.success((String) authenticationRequest.getIdentity(),new ArrayList<String>(), Map.of()));
                    emitter.onComplete();
                }
                else{
                    emitter.onError(new AuthenticationException(new AuthenticationFailed("Passwords do not matches")));
                }
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed("User does not exist")));
            }
        }, BackpressureStrategy.ERROR);
    }

    private Optional<UserDto> checkIfUserExists(AuthenticationRequest<?, ?> authenticationRequest) {
        Optional<UserDto> optionalUserDto = Optional.empty();
        if (authenticationRequest.getIdentity() instanceof String) {
            String username = authenticationRequest.getIdentity().toString();
            optionalUserDto =  userService.findByUsername(username);
            return optionalUserDto;
        }

       return optionalUserDto;
    }

}
