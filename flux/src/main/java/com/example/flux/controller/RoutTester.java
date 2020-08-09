package com.example.flux.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutTester {

    @Bean
    public RouterFunction<ServerResponse> testRouter(RouteHandler handler)
    {
       return RouterFunctions
                .route(RequestPredicates.GET("/test").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),handler::getresponse)
                .andRoute(RequestPredicates.GET("/test").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),handler::getresponse);
    }
}
