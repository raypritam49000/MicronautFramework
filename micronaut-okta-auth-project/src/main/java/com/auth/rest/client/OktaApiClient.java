//package com.auth.rest.client;
//
//import io.micronaut.http.HttpRequest;
//import io.micronaut.http.client.HttpClient;
//import io.micronaut.http.client.annotation.Client;
//import jakarta.inject.Singleton;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.Map;
//
//@Singleton
//public class OktaApiClient {
//
//    private static final Logger LOG = LoggerFactory.getLogger(OktaApiClient.class);
//
//    private static final String OKTA_API_ENDPOINT = "https://dev-66461681-admin.okta.com/oauth2/v1/userinfo";
//    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
//
//    private final HttpClient httpClient;
//
//    public OktaApiClient(@Client("okta") HttpClient httpClient) {
//        this.httpClient = httpClient;
//    }
//
//    public Map<?,?> getUserInfo(String accessToken) {
//        try {
//            HttpRequest<?> httpRequest = HttpRequest.GET(OKTA_API_ENDPOINT).bearerAuth(accessToken);
//            Map<?,?> response = httpClient.toBlocking().retrieve(httpRequest, Map.class);
//
//            if (response == null || response.isEmpty()) {
//                throw new RuntimeException("Invalid user info response from Okta API");
//            }
//
//            return response;
//        } catch (Exception e) {
//            LOG.error("Failed to retrieve user info from Okta API: " + e.getMessage(), e);
//            throw new RuntimeException("Failed to retrieve user info from Okta API");
//        }
//    }
//}
