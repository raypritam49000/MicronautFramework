//package com.jwt.cookie.rest.api.filters;
//
//import com.nimbusds.jwt.JWTParser;
//import io.micronaut.http.HttpRequest;
//import io.micronaut.http.HttpResponse;
//import io.micronaut.http.annotation.Filter;
//import io.micronaut.http.filter.FilterChain;
//import io.micronaut.http.filter.HttpFilter;
//import io.micronaut.security.token.jwt.validator.JwtValidator;
//import io.reactivex.Flowable;
//import org.reactivestreams.Publisher;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Optional;
//
//@Filter("/hello")
//public class JwtAuthenticationFilter implements HttpFilter {
//    private final Logger LOGGER  = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
//        LOGGER.info("@@@ Going to JwtAuthenticationFilter");
//        Optional<String> token = request.getCookies().findCookie("JWT").map(cookie -> cookie.getValue());
//        if (token.isEmpty()) {
//            LOGGER.error("@@@ Token does not exits");
//            return Flowable.just(HttpResponse.unauthorized());
//        }
//        try {
//            LOGGER.info("@@@ Token : "+token.get());
//            JWTParser.parse(token.get());
//        } catch (Exception e) {
//            LOGGER.info("@@@ Going to JwtAuthenticationFilter Exception Message: "+e.getMessage());
//            return Flowable.just(HttpResponse.unauthorized());
//        }
//        return chain.proceed(request);
//    }
//
//
//}
