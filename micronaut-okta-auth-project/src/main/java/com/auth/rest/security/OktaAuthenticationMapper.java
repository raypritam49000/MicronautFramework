//package com.auth.rest.security;
//
//import com.auth.rest.client.OktaApiClient;
//import io.micronaut.core.annotation.Nullable;
//import io.micronaut.security.authentication.AuthenticationResponse;
//import io.micronaut.security.oauth2.endpoint.authorization.state.State;
//import io.micronaut.security.oauth2.endpoint.token.response.OauthAuthenticationMapper;
//import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
//import jakarta.inject.Inject;
//import jakarta.inject.Named;
//import jakarta.inject.Singleton;
//import org.reactivestreams.Publisher;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import reactor.core.publisher.Mono;
//
//import java.util.Collections;
//import java.util.Map;
//
//
//@Singleton
//@Named("okta")
//public class OktaAuthenticationMapper implements OauthAuthenticationMapper {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//    public static final String TOKEN_PREFIX = "Bearer ";
//    public static final String ROLE_OKTA = "ROLE_OKTA";
//    private OktaApiClient oktaApiClient;
//
//    @Inject
//    public void setOktaApiClient(OktaApiClient oktaApiClient) {
//        this.oktaApiClient = oktaApiClient;
//    }
//
//    @Override
//    public Publisher<AuthenticationResponse> createAuthenticationResponse(TokenResponse tokenResponse,
//                                                                          @Nullable State state) {
//        LOGGER.info("@@@ token : "+tokenResponse.getAccessToken());
//        Map<?, ?> userInfo = oktaApiClient.getUserInfo(TOKEN_PREFIX + tokenResponse.getAccessToken());
//        String username = (String) userInfo.get("preferred_username");
//        String email = (String) userInfo.get("email");
//
//        return Mono.just(AuthenticationResponse.success(username,
//                Collections.singletonList(ROLE_OKTA),
//                Collections.singletonMap("email", email)));
//    }
//
//
//}